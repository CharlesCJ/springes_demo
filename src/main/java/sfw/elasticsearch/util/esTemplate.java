package sfw.elasticsearch.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;

@Component
public class esTemplate {
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	/**
	 * 创建Indices
	 * @param cls
	 */
	public <T> void createIndex(Class<T> cls){
		 elasticsearchTemplate.createIndex(cls);
	}
	
	/**
	 * 删除Indices
	 * @param cls
	 */
	public <T> void deleteIndex(Class<T> cls){
		elasticsearchTemplate.deleteIndex(cls);
	}
	
	/**
	 * 根据指定indexname，type，id删除数据
	 * @param indexName
	 * @param type
	 * @param id
	 */
	public void delete(String indexName, String type, String id){
		elasticsearchTemplate.delete(indexName,type,id);
	}
	
	/**
	 * 插入数据
	 * @param indexQuery
	 */
	public void index(IndexQuery indexQuery){
		elasticsearchTemplate.index(indexQuery);
	}
	
	/**
	 * 批量插入数据
	 * @param indexQuerys
	 */
	public void bulkIndex(List<IndexQuery> indexQuerys){
		elasticsearchTemplate.bulkIndex(indexQuerys);
	}
	
	/**
	 * 更新数据
	 * @param cls
	 * @param bln
	 */
	public <T> void refresh(Class<T> cls, boolean bln){
		elasticsearchTemplate.refresh(cls, bln);
	}
	
	/**
	 * 是否存在indexname为指定字符串的记录
	 * @param str
	 * @return boolean
	 */
	public boolean indexExists(String str){
		if(elasticsearchTemplate.indexExists(str)){
			return true;
		}
		return false;
	}
	
	/**
	 * 是否存在Indices为指定Class的记录
	 * @param str
	 * @return boolean
	 */
	public <T> boolean indexExists(Class<T> cls){
		if(elasticsearchTemplate.indexExists(cls)){
			return true;
		}
		return false;
	}
	
	/**
	 * search
	 * @param searchQuery
	 * @param cls
	 * @return List<T>
	 */
	public <T> List<T> queryForList(SearchQuery searchQuery, Class<T> cls){
		return elasticsearchTemplate.queryForList(searchQuery, cls);
	}
}
