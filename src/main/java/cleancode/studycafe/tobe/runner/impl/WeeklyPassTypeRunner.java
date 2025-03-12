package cleancode.studycafe.tobe.runner.impl;

import cleancode.studycafe.tobe.io.InputHandler;
import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.io.StudyCafeFileHandler;
import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePass;
import cleancode.studycafe.tobe.model.StudyCafePassType;
import cleancode.studycafe.tobe.model.collection.StudyCafePassList;
import cleancode.studycafe.tobe.runner.StudyCafeTypeRunner;
import java.util.List;

public class WeeklyPassTypeRunner extends StudyCafeTypeRunner {
  private static final StudyCafePassType PASS_TYPE = StudyCafePassType.WEEKLY;

  private final StudyCafeFileHandler studyCafeFileHandler;
  private final InputHandler inputHandler;
  private final OutputHandler outputHandler;

  public WeeklyPassTypeRunner(StudyCafeFileHandler studyCafeFileHandler,
      InputHandler inputHandler,
      OutputHandler outputHandler) {
    this.studyCafeFileHandler = studyCafeFileHandler;
    this.inputHandler = inputHandler;
    this.outputHandler = outputHandler;
  }

  @Override
  public StudyCafePassList getFilteredPasses() {
    StudyCafePassList studyCafePassList = studyCafeFileHandler.readStudyCafePasses();
    return studyCafePassList.getSelectedPasses(PASS_TYPE);
  }

  @Override
  public void showPassListForSelection(StudyCafePassList passes) {
    outputHandler.showPassListForSelection(passes);

  }

  @Override
  public StudyCafePass getSelectPass(StudyCafePassList passes) {
    return inputHandler.getSelectPass(passes);
  }

  @Override
  public void showPassOrderSummary(StudyCafePass pass, StudyCafeLockerPass lockerPass) {
    outputHandler.showPassOrderSummary(pass, null);
  }

  @Override
  public StudyCafeLockerPass getLockerPass(StudyCafePass selectedPass) {
    return null;
  }
}
