package dao.impl;

import com.example.Scheman.TestDataUtil;
import com.example.Scheman.dao.impl.AuthorDaoImpl;
import com.example.Scheman.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;

//@SpringBootTest
//@ExtendWith(SpringExtension.class)
public class AuthorDaoImplIntegrationTest {

    private AuthorDaoImpl underTest;

    @Autowired
    public AuthorDaoImplIntegrationTest(AuthorDaoImpl underTest){

        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRead(){

        Author author = TestDataUtil.createTestAuthor();
        underTest.create(author);
        Optional<Author> result = underTest.findOne(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);




    }

}
