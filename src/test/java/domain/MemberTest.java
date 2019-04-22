package domain;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import repository.MockRepository;
import service.MockService;

import java.nio.channels.FileChannel;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MemberTest {
    @Mock
    private MockRepository mockRepository;

    @InjectMocks
    private MockService mockService;

    @Test
    public void findNameAndGender(){
        Member member = new Member("양명우", "male", "0107338676", 24);
        List<Member> memberList = new ArrayList<Member>();
        memberList.add(member);

        when(mockService.findByName("양명우")).thenReturn(memberList.get(0));
        String memberGender = mockService.findByName("양명우").getGender();
        assertThat(memberGender, is("male"));
    }
}