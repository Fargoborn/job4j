package ru.job4j.pseudo;

/**
 * @author
 * @version $Id$
 * @since 0.1
 */
public class Square implements Shape {

  @Override
  public String draw() {
    StringBuilder pic = new StringBuilder();
    pic.append("++++\n");
    pic.append("+--+\n");
    pic.append("+--+\n");
    pic.append("++++");
    return pic.toString();
  }
}


