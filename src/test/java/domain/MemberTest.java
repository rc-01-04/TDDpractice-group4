package domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MemberTest {

    @Test
    public void testAddsetGender(){
            Member member=new Member();
            member.setGender("female");
            assertThat(member.getGender(),is("female"));
    }

    @Test
    public void testAddsetCellphoneNumber(){
        Member member=new Member();
        member.setCellphoneNumber("01055551111");
        assertThat(member.getCellphoneNumber(),is("01055551111"));
    }

    @Test
    public void testAddsetAge(){
        Member member=new Member();
        member.setAge(25);
        assertThat(member.getAge(),is(25));
    }

}