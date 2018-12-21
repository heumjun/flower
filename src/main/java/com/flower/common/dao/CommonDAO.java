package com.flower.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @파일명		: CommonDAO.java 
 * @프로젝트	: flower
 * @날짜		: 2018. 11. 22. 
 * @작성자		: Cho HeumJun
 * @설명
 * <pre>
 * 		공통 DAO
 * </pre>
 */

@Repository("commonDAO")
public class CommonDAO
{
	protected Log				log	= LogFactory.getLog(CommonDAO.class);

	@Autowired
	private SqlSessionTemplate	flowerSession;

	/**
	 * 
	 * @메소드명	: printQueryId
	 * @날짜		: 2018. 11. 22.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		로그출력
	 * </pre>
	 * @param queryId
	 */
	protected void printQueryId(String queryId)
	{
		if (log.isDebugEnabled())
		{
			log.debug("\t QueryId  \t:  " + queryId);
		}
	}
	
	protected void printQueryIdERP(String queryId)
	{
		if (log.isDebugEnabled())
		{
			log.debug("\t QueryId  \t:  " + queryId);
		}
	}

	public int insert(String queryId, Object params)
	{
		printQueryId(queryId);
		return flowerSession.insert(queryId, params);
	}

	public int update(String queryId, Object params)
	{
		printQueryId(queryId);
		return flowerSession.update(queryId, params);
	}

	public int delete(String queryId, Object params)
	{
		printQueryId(queryId);
		return flowerSession.delete(queryId, params);
	}

	public Object selectOne(String queryId)
	{
		printQueryId(queryId);
		return flowerSession.selectOne(queryId);
	}

	public <T> T selectOne(String queryId, Object params)
	{
		printQueryId(queryId);
		return flowerSession.selectOne(queryId, params);
	}

	public List<Object> selectList(String queryId)
	{
		printQueryId(queryId);
		return flowerSession.selectList(queryId);
	}

	public List<Map<String, Object>> selectList(String queryId, Object params)
	{
		printQueryId(queryId);
		return flowerSession.selectList(queryId, params);
	}

}