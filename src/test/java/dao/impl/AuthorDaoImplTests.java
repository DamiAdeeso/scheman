package dao.impl;

import com.example.Scheman.TestDataUtil;
import com.example.Scheman.dao.impl.AuthorDaoImpl;
import com.example.Scheman.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl underTest;

    @Test
    public void testThatCreatesAuthorGeneratesCorrectSQL(){
        Author author = TestDataUtil.createTestAuthor();
        underTest.create(author);
        jdbcTemplate.update(
                "INSERT INTO authors(id,name,age) VALUES (?,?,?",
                1L,
                "ade",
                12
        );

    }

    @Test
    public void testThatFindOneGeneratesTheCorrectSQL(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
                eq("SELECT id,name,age From authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),eq( 1L)
                );
    }


}
