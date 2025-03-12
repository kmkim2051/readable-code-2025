package cleancode.studycafe.tobe.runner.impl;

import cleancode.studycafe.tobe.io.InputHandler;
import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.io.StudyCafeFileHandler;
import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePass;
import cleancode.studycafe.tobe.model.StudyCafePassType;
import cleancode.studycafe.tobe.model.collection.StudyCafeLockerPassList;
import cleancode.studycafe.tobe.model.collection.StudyCafePassList;
import cleancode.studycafe.tobe.runner.StudyCafeTypeRunner;

public class FixedPassTypeRunner extends StudyCafeTypeRunner {
  private static final StudyCafePassType PASS_TYPE = StudyCafePassType.FIXED;

  private final StudyCafeFileHandler studyCafeFileHandler;
  private final InputHandler inputHandler;
  private final OutputHandler outputHandler;

  public FixedPassTypeRunner(StudyCafeFileHandler studyCafeFileHandler,
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
  public StudyCafeLockerPass getLockerPass(StudyCafePass selectedPass) {
    StudyCafeLockerPassList studyCafeLockerPassList = studyCafeFileHandler.readLockerPasses();
    return studyCafeLockerPassList.getSelectedPath(selectedPass);
  }

  @Override
  public void showPassOrderSummary(StudyCafePass pass, StudyCafeLockerPass lockerPass) {
    boolean lockerSelection = false;
    if (lockerPass != null) {
      outputHandler.askLockerPass(lockerPass);
      lockerSelection = inputHandler.getLockerSelection();
    }

    if (lockerSelection) {
      outputHandler.showPassOrderSummary(pass, lockerPass);
    } else {
      outputHandler.showPassOrderSummary(pass, null);
    }
  }
}

