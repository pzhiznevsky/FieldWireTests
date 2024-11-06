package com.fieldwire.test.ui.tests.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import static com.fieldwire.test.ui.tests.util.RandomGenerator.getRandomString;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class Task {

    @Builder.Default
    private String title = getRandomString() + "Title";

}