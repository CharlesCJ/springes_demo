package sfwtest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.IndexQuery;

import sfw.elasticsearch.controller.test;
import sfw.elasticsearch.entity.Car;
import sfw.elasticsearch.entity.Person;
import junit.framework.TestCase;

public class TestesTemplate extends TestCase {

	test t = new test();
	
	public void testAdd() throws Exception{
		Person foo = new Person();
		foo.setName("Foo1");
		foo.setId("8");
		
		List cars = new ArrayList();
		
		 Car malibu = new Car();
		 malibu.setName("科鲁兹333");
		 malibu.setModel("2.0");
		 cars.add(malibu);
		 foo.setCar(cars);
		
		 IndexQuery indexQuery = new IndexQuery();
		 IndexQuery indexQuery1 = new IndexQuery();
		 indexQuery.setId(foo.getId());
		 indexQuery.setObject(foo);
		 
		 t.setPerson(foo);
		 
	}
	
}
