package domain;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import repository.MockRepository;
import service.MockService;

import java.util.ArrayList;
import static org.mockito.Mockito.when;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MemberTest {
    @Mock
    private MockRepository mockRepository;

    @InjectMocks
    private MockService mockService;
    // ------------ 명우 ------------ //
    @Test
    public void findNameAndGender(){
        Member member = new Member("양명우", "male", "0107338676", 24);
        List<Member> memberList = new ArrayList<Member>();
        memberList.add(member);

        when(mockService.findByName("양명우")).thenReturn(memberList.get(0));
        String memberGender = mockService.findByName("양명우").getGender();
        assertThat(memberGender, is("male"));
    }
    // 
  
  
    // ------------ 현송 ------------ //
    @Test
    public void testSetGender(){
            Member member=new Member();
            member.setGender("female");
            assertThat(member.getGender(),is("female"));
    }

    @Test
    public void testSetCellphoneNumber(){
        Member member=new Member();
        member.setCellphoneNumber("01055551111");
        assertThat(member.getCellphoneNumber(),is("01055551111"));
    }

    @Test
    public void testSetAge(){
        Member member=new Member();
        member.setAge(25);
        assertThat(member.getAge(),is(25));
    }
    // 

  
  
    // ------------ 승민 ------------ //
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
    // 
}