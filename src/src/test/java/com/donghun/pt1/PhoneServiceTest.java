package com.donghun.pt1;

import com.donghun.pt3.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneServiceTest {

    @Mock
    PhoneRepository phoneRepository;

    @Test
    public void save() {
        Phone phone = new Phone();

        when(phoneRepository.save(phone)).thenReturn(phone);
        PhoneService phoneService = new PhoneService(phoneRepository);
        Phone result = phoneService.save(phone);

        assertThat(phone.getCreated()).isNotNull();
        assertThat(phone.getPhoneStatus()).isEqualTo(PhoneStatus.IPHONE);
        assertThat(result).isNotNull();
    }

}