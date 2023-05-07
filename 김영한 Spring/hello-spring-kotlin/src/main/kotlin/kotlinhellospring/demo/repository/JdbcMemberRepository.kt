package kotlinhellospring.demo.repository

import kotlinhellospring.demo.domain.Member
import org.springframework.jdbc.datasource.DataSourceUtils
import java.sql.*
import javax.sql.DataSource

class JdbcMemberRepository(
    /* DB에 붙으려면 DataSource가 필요함 */
    private val dataSource: DataSource,
) : MemberRepository {


    private fun getConnection(): Connection {
        return DataSourceUtils.getConnection(dataSource)
    }

    private fun close(
        conn: Connection?,
        pstmt: PreparedStatement?,
        rs: ResultSet?,
    ) {
        try {
            conn?.close()
            pstmt?.close()
            rs?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun save(member: Member): Member {
        var sql = "insert into Member(name) values(?)" // Paramemter를 Binding하기 위한 '?'임.
        var conn: Connection? = null
        var pstmt: PreparedStatement? = null
        var rs: ResultSet? = null

        try {
            conn = getConnection()
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
            pstmt.setString(1, member.name)


            // insert 할 때 getGenerateKeys!
            val i = pstmt.executeUpdate()
            rs = pstmt.getGeneratedKeys()

            if (rs.next()) {
                member.id = rs.getLong(1)
            } else {
                throw SQLException("id 조회 실패")
            }

            return member
        } catch (e: Exception) {
            throw IllegalStateException()
        } finally {
            close(conn, pstmt, rs)
        }
    }

    override fun findById(id: Long): Member? {
        var sql = "select * from member where id = ?" // Paramemter를 Binding하기 위한 '?'임.
        var conn: Connection? = null
        var pstmt: PreparedStatement? = null
        var rs: ResultSet? = null

        try {
            conn = getConnection()
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
            pstmt.setLong(1, id)

            rs = pstmt.executeQuery()

            return rs.next().let {
                Member().apply {
                    this.id = rs.getLong("id")
                    this.name = rs.getString("name")
                }
            }
        } catch (e: Exception) {
            throw IllegalStateException()
        } finally {
            close(conn, pstmt, rs)
        }
    }

    override fun findByName(name: String?): Member? {
        val sql = "select * from member where name = ?"

        var conn: Connection? = null
        var pstmt: PreparedStatement? = null
        var rs: ResultSet? = null

        try {
            conn = getConnection()
            pstmt = conn.prepareStatement(sql)
            pstmt.setString(1, name)

            rs = pstmt.executeQuery()

            return rs.next().let {
                 Member().apply {
                    this.id = rs.getLong("id")
                    this.name = rs.getString("name")
                }
            }
        } catch (e: Exception) {
            throw IllegalStateException()
        } finally {
            close(conn, pstmt, rs)
        }
    }

    override fun findAll(): List<Member> {
        val sql = "select * from member"
        var conn: Connection? = null
        var pstmt: PreparedStatement? = null
        var rs: ResultSet? = null

        try {
            conn = getConnection()
            pstmt = conn.prepareStatement(sql)
            rs = pstmt.executeQuery()

            val members = mutableListOf<Member>()

            while (rs.next()) {
                val member = Member().apply {
                    this.id = rs.getLong("id")
                    this.name = rs.getString("name")
                }
                members.add(member)
            }

            return members

        } catch (e: Exception) {
            throw IllegalStateException()
        } finally {
            close(conn, pstmt, rs)
        }
    }
}