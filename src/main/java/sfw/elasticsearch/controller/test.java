package sfw.elasticsearch.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sfw.elasticsearch.entity.Person;
import sfw.elasticsearch.util.esTemplate;

@Controller
public class test {

	@Autowired
	private esTemplate esTemplate;
	
	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("index");
	}

	private Person person;
	

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		
		 //删除指定index-type-id
//		 esTemplate.delete("person", "user", "1");
		 //删除Indices
//		 esTemplate.deleteIndex(Person.class);
		 
//		 esTemplate.createIndex(Person.class);
		 
		 //add index
		
		IndexQuery indexQuery = new IndexQuery();
		indexQuery.setId(person.getId());
		indexQuery.setObject(person);
		 esTemplate.index(indexQuery);
		 //add indexs
//		 esTemplate.bulkIndex(indexQuerys);
//		 
//		 //refresh index
//		 esTemplate.refresh(Person.class, true);
//		 
//		 //是否存在indices,return boolean
//		 if(esTemplate.indexExists(Person.class))
//			 System.out.println("exist person indices");
//		 else
//			 System.out.println("no person indices");
//		 //是否存在indexname为person的记录,return boolean
//		 if(esTemplate.indexExists("person"))
//			 System.out.println("exist person indexName");
//		 else
//			 System.out.println("no person indexName");
//		 
//		 
		 //search
		 QueryBuilder qb = QueryBuilders.boolQuery()
		          .must(QueryBuilders.matchPhraseQuery("car.name", "迈瑞宝"));
		 /*new NativeSearchQueryBuilder()指定范围
			new NativeSearchQueryBuilder().withIndices(Indices).withTypes(types).withIds(Collection<String> ids)
		  */
		 SearchQuery searchQuery = new NativeSearchQueryBuilder().withIndices("person").withQuery(qb).build();
		 List<Person> persons = esTemplate.queryForList(searchQuery, Person.class);
		 if(persons.size() == 0){
			 System.out.println("size = 0");
		 }else{
			 for(int i=0;i!=persons.size();++i){
				 System.out.println(persons.get(i).toString());
			 }
		 }
		 
		 
		 return new ModelAndView("index");
	}

}
