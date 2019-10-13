package com.kk;

import com.google.gson.JsonObject;
import com.kk.domain.Article;
import com.kk.domain.User;
import com.kk.repositry.UserRepository;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.*;
import io.searchbox.indices.mapping.GetMapping;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JestApplicationTest {


	@Autowired
	private JestClient jestClient;

	@Autowired
	private UserRepository userRepository;


	//在kk索引的book类型下新增一个文章类型的文档
	@Test
	public void addData() throws IOException {
		Article article = new Article(1, "西游记", "吴承恩", 15);
		Index build = new Index.Builder(article).index("kk").type("book").build();
		DocumentResult execute = jestClient.execute(build);
		boolean succeeded = execute.isSucceeded();
		System.out.println("succeeded = " + succeeded);
	}

	@Test
	public void search() throws IOException {
		String json = "{query:{match:{name:西游记}}}";
		Search search = new Search.Builder(json).addIndex("kk").addType("book").build();
		SearchResult execute = jestClient.execute(search);
		JsonObject jsonObject = execute.getJsonObject();
		System.out.println("jsonObject = " + jsonObject);
	}


	//获取kk索引下所有的book类型数据
	@Test
	public void getData() throws IOException {
		GetMapping.Builder builder = new GetMapping.Builder();
		builder.addIndex("kk");
		builder.addType("book");
		GetMapping getMapping = builder.build();
		JestResult execute = jestClient.execute(getMapping);
		JsonObject jsonObject = execute.getJsonObject();
		System.out.println("jsonString = " + jsonObject);
	}

	@Test
	public void batchAddIndex() throws IOException {
		List<Article> articles = generateObjects(100);
		Bulk.Builder builder = new Bulk.Builder();
		builder.defaultIndex("kk");
		builder.defaultType("book");

		articles.forEach(article->{
			Index index = new Index.Builder(article).build();
			builder.addAction(index);
		});

		Bulk bulk = builder.build();

		BulkResult execute = jestClient.execute(bulk);
		boolean succeeded = execute.isSucceeded();
		System.out.println("succeeded = " + succeeded);


	}

	private List<Article> generateObjects(int count){
		ArrayList<Article> lists = new ArrayList<>();
		for(int i=0;i<count;i++){
			Article article = new Article(i, "西游记", "吴承恩", 15);
			lists.add(article);
		}
		return lists;
	}

	@Test
	public  void addUser(){
		User user = new User();
		user.setId(1);
		user.setName("sdasd");
		userRepository.index(user);
	}

	@Test
	public void findUser(){
		List<User> as = userRepository.findUserByNameLike("as");
		as.forEach(e-> System.out.println("e = " + e));
	}




}
