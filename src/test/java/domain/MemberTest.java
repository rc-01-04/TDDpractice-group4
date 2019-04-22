package domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MemberTest {

    @Test
    public void TestAddGender(String gender){
            Member member=mock(Member.class);
            member.setGender(gender);
            verify(member).setGender(gender);
            assertThat(member.getGender(),is(gender));
    }

}