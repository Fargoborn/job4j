package ru.job4j.calculate;

/**
* Calculate.
*
* @author Denis Barshchevsky (dealba1@yandex.ru)
*/
public class Calculate {
/**
* Main.
*@param args - args.
*/
  public static void main(String[] args) {
  Calculate calc = new Calculate();
    System.out.println(calc.echo("aah"));
  }
/**
* Method echo.
* @param name Your name.
* @return Echo plus your name.
*/
 public String echo(String name) {
    return "Echo, echo, echo : " + name;
 }
}
