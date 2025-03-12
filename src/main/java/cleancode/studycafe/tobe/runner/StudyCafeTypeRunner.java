package cleancode.studycafe.tobe.runner;

import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePass;
import cleancode.studycafe.tobe.model.collection.StudyCafePassList;

public abstract class StudyCafeTypeRunner {
  public void run() {
    StudyCafePassList filteredPasses = getFilteredPasses();

    showPassListForSelection(filteredPasses);

    StudyCafePass selectedPass = getSelectPass(filteredPasses);
    StudyCafeLockerPass studyCafeLockerPass = getLockerPass(selectedPass);

    showPassOrderSummary(selectedPass, studyCafeLockerPass);
  }

  public abstract StudyCafePassList getFilteredPasses();
  public abstract void showPassListForSelection(StudyCafePassList passes);

  public abstract StudyCafePass getSelectPass(StudyCafePassList passes);
  public abstract StudyCafeLockerPass getLockerPass(StudyCafePass selectedPass);

  public abstract void showPassOrderSummary(StudyCafePass pass, StudyCafeLockerPass lockerPass);
}
