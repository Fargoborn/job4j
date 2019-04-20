package ru.job4j.tracker;

public abstract class BaseAction implements UserAction {
  private final int key;
  private final String nameaction;

  protected BaseAction(final int key, final String nameaction) {
    this.key = key;
    this.nameaction = nameaction;
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
