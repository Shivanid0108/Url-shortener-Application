package com.url.shortener.service;

import org.junit.jupiter.api.Test;

import static com.url.shortener.service.Base62Encoder.encode;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class BaseEncoderTest {
    @Test
    void encodesZero() {
        assertThat(encode(0)).isEqualTo("0");
    }

    @Test
    void encodes62() {
        assertThat(encode(62)).isEqualTo("10");
    }

    @Test
    void encodes125() {
        assertThat(encode(125)).isEqualTo("21");
    }

    @Test
    void decodes21() {
        assertThat(Base62Encoder.decode("21")).isEqualTo(125);
    }

    @Test
    void roundTrip() {
        assertThat(Base62Encoder.decode(encode(999999))).isEqualTo(999999L);
    }

    @Test
    void decodeRejectsInvalidCharacter() {
        assertThatThrownBy(() -> Base62Encoder.decode("ab$"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void encodeRejectsNegative() {
        assertThatThrownBy(() -> Base62Encoder.encode(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }


}



