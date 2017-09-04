package by.apertura.model;

import by.apertura.util.HibernateMappingUtils;
import by.apertura.util.SequenceIncrementValidator;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class HibernateMappingTest
{
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * This test iterates the whole Hibernate configuration checking is the SQL
     * tables and columns are right.
     */
    @Test
    public void testEverything()
    {
        HibernateMappingUtils.testHibernateMapping(sessionFactory);
    }

    @Test
    public void ensureCorrectSequenceIncrement()
    {
        new SequenceIncrementValidator().validateSequenceGeneratorIncrement(sessionFactory);
    }

}
