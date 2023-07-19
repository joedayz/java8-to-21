package org.example;

import java.lang.annotation.Repeatable;

@Repeatable(Allows.class)
public @interface Allow {

  String group();
}
