package cs3500.animator.controller.commands;

import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.BasicShape;

/**
 * Command Handler for Create Command.
 */
public class CreateCommand implements AnimatorCommand {
  private String tag;
  private BasicShape shape;
  private AnimatorModel model;

  /**
   * Constructor for Create Command.
   * @param params is the string input for parameters
   * @param model is the model
   */
  public CreateCommand(String params, AnimatorModel model) {
    String[] lop = params.split(",");
    if (lop.length == 1) {
      throw new IllegalArgumentException("Create Command Must Contain Both Parameters.");
    } else {
      this.tag = lop[0];
      switch (lop[1]) {
        case "Rectangle":
        case "rect":
          this.shape = BasicShape.RECTANGLE;
          break;
        case "Oval":
        case "ovl":
          this.shape = BasicShape.OVAL;
          break;
        case "Triangle":
        case "tri":
          this.shape = BasicShape.TRIANGLE;
          break;
        default:
          throw new IllegalArgumentException("Invalid Shape, Cannot Identify input.");
      }
    }
    this.model = model;
  }

  public String getTag() {
    return this.tag;
  }

  public void build() {
    this.model.createShape(this.tag, this.shape);
  }
}
