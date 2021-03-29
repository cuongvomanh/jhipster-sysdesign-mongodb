package com.mycompany.mygroup.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountMapperTest {

    private BankAccountMapper bankAccountMapper;

    @BeforeEach
    public void setUp() {
        bankAccountMapper = new BankAccountMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id1";
        assertThat(bankAccountMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(bankAccountMapper.fromId(null)).isNull();
    }
}
