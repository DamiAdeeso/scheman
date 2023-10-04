package dao.impl;

import com.example.Scheman.dao.impl.BooksDaoImpl;
import com.example.Scheman.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import static org.mockito.ArgumentMatchers.eq;


@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private BooksDaoImpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSQL(){
        Book book = Book.builder()
                .isbn("123456")
                .title("The Shadow")
                .authorId(1l)
                .build();

        underTest.create(book);
        Mockito.verify(jdbcTemplate).update(
                eq("INSERT into books (isbn,title,author_id) Values (?,?,?)"),
                eq("123456"),
                eq("The Shadow"),
                eq(1L)
        );




    }
    @Test
    public void testThatFindOneGeneratesCorrectSQL(){
        underTest.find("123456");
        Mockito.verify(jdbcTemplate).query(
                eq("SELECT isbn,title,author_id from books WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<BooksDaoImpl.BookRowMapper>any(),
                eq("123456")
        );

    }


}
