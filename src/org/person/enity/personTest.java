package org.person.enity;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

public class personTest {

    public static void main(String[] args) {
        try {
            Reader reader = Resources.getResourceAsReader("config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            String statement = "org.person.enity.personmapper.queryAll";
            person p = session.selectOne(statement);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
