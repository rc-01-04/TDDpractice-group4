package domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MemberTest {

    // 나이 설정시, 유효값이 아닐 때 예외상황으로 잘 처리 되는지 테스트
    @Test(expected = IllegalArgumentException.class)
    public void testSetAgeException() {
        Member member = new Member();
        member.setAge(-2);
        assertThat(member.getAge(), is(-2));
    }

    // 휴대폰 번호를 변경했을 때, 잘 변경되는지 테스트
    @Test
    public void testChangePhoneNumber() {
        Member member = new Member();
        member.setCellphoneNumber("01012345678");
        assertThat(member.getCellphoneNumber(), is("01012345678"));

        member.setCellphoneNumber("01011112222");
        assertThat(member.getCellphoneNumber(), is("01011112222"));
    }

    // 나이를 한 살 추가했을때, 잘 변경되는지 테스트
    @Test
    public void testAddAge() {
        Member member = new Member();

        int age = 5;
        member.setAge(age);
        assertThat(member.getAge(), is(age));
        member.addAge();
        assertThat(member.getAge(), is(age+1));
    }
}