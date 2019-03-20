package ru.job4j.calculate;

/**
* Calculate.
*
* @author Denis Barshchevsky (dealba1@yandex.ru)
*/
public class Calculate{
	public String echo(String value){
	return String.format("%s %s %s", value, value, value);
	}

/**
* Main.
*@param args - args.
*/
  public static void main(String[] args){
  Calculate calc = new Calculate();
    System.out.println(calc.echo("aah"));
  }
}
