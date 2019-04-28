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
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class MemberTest {
    @Mock
    private MockRepository mockRepository;

    @InjectMocks
    private MockService mockService;
    // ------------ 명우 ------------ //
    @Test
    public void TestGetName(){
        Member member = mock(Member.class);
        when(member.getName()).thenReturn("전승민");
        assertThat(member.getName(), is("전승민"));
    }

    @Test
    public void TestGetGender(){
        Member member = mock(Member.class);
        when(member.getGender()).thenReturn("male");
        assertThat(member.getGender(), is("male"));
    }
    @Test
    public void TestGetPhoneNumber(){
        Member member = mock(Member.class);
        when(member.getCellphoneNumber()).thenReturn("01073396678");
        assertThat(member.getCellphoneNumber(), is("01073396678"));
    }
    @Test
    public void TestGetAge(){
        Member member = mock(Member.class);
        when(member.getAge()).thenReturn(24);
        assertEquals(member.getAge(), 25);
    }

    @Test
    public void TestfindNameAndGender(){
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

    // ------------ 재홍 ------------ //
    // 특정 멤버의 이름을 받으면 임의의 정보를 설정하고, 설정한 정보가 맞는지 확인
    @Test
    public void searchNameTest(){
        when(mockService.findByName("배재홍")).thenReturn(new Member("배재홍","male","010-0000-0005",23));
        Member member = mockService.findByName("배재홍");
        assertThat(member.getAge(), is(23));
        assertThat(member.getName(), is("배재홍"));
        assertThat(member.getCellphoneNumber(),is("010-0000-0005"));
        assertThat(member.getGender(),is("male"));
    }
    // 성별 입력이 남,여가 아닌 다른 내용이 들어 왔을때 에러가 발생하는지 확인
    @Test(expected = IllegalArgumentException.class)
    public void inputgenderTest(){
        Member member = new Member();
        member.setGender("배재홍");
        assertThat(member.getGender(), is("배재홍"));
    }

    //여러명의 멤버를 받고 , 해당 멤버를 찾으면 제대로 찾아지는지 확인
    @Test
    public void searchListNameTest(){

        Member member = new Member("배재홍","male","010-1111-1112",23);
        Member member1 = new Member("권현송","female","010-1123-4856",25);
        Member member2 = new Member("전승민","male","010-4444-4111",20);
        Member member3 = new Member("양명우","male","0235-12313-55",25);

        mockService.addMember(member);
        mockService.addMember(member1);
        mockService.addMember(member2);
        mockService.addMember(member3);

        when(mockService.findByName("배재홍")).thenReturn(member);
        assertThat(member.getName(),is("배재홍"));


    }

}