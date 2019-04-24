package ru.job4j.tracker;

public abstract class BaseAction implements UserAction {
  private final int key;
  private final String nameaction;
  private final StartUI ui;

  protected BaseAction(final int key, final String nameaction, StartUI ui) {
    this.key = key;
    this.nameaction = nameaction;
    this.ui = ui;
  }

  @Override
  public int key() {
    return this.key;
  }

  @Override
  public String info() {
    return String.format("%s. %s", this.key, this.nameaction);
  }
}
