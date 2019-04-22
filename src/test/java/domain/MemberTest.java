package domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MemberTest {

    @Test
    public void testAddGender(){
            Member member=new Member();
            member.setGender("female");
            assertThat(member.getGender(),is("female"));
    }
    
}