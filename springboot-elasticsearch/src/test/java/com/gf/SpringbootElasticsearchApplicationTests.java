package com.gf;

import com.gf.entity.Book;
import com.gf.repository.BookRepository;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElasticsearchApplicationTests {

	@Autowired
	BookRepository bookRepository;

	@Test
	public void createIndex2(){
		Book book = new Book();
		book.setId(1);
		book.setBookName("西游记");
		book.setAuthor( "吴承恩" );
		bookRepository.index( book );
	}

	@Test
	public void useFind() {
		List<Book> list = bookRepository.findByBookNameLike( "游" );
		for (Book book : list) {
			System.out.println(book);
		}

	}

}
