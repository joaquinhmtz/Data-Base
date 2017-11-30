package Web.codigo.controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisController {

    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession = null;


    public MybatisController(SqlSessionFactory sqlSessionFactory, SqlSession sqlSession) {
        this.sqlSessionFactory = sqlSessionFactory;
        this.sqlSession = sqlSession;
    }

    public MybatisController() {
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public SqlSession conexion() {

        SqlSession sqlSession_aux=null;

        try {

            String resource = "conf.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession_aux = sqlSessionFactory.openSession();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return sqlSession_aux;

    }
}
