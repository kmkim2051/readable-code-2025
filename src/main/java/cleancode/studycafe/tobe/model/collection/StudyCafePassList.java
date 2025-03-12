package cleancode.studycafe.tobe.model.collection;

import cleancode.studycafe.tobe.model.StudyCafePass;
import cleancode.studycafe.tobe.model.StudyCafePassType;
import java.util.List;

public class StudyCafePassList {
  private final List<StudyCafePass> passes;

  private StudyCafePassList(List<StudyCafePass> passes) {
    this.passes = passes;
  }

  public StudyCafePassList getSelectedPasses(StudyCafePassType passType) {
    List<StudyCafePass> list = passes.stream()
        .filter(studyCafePass -> studyCafePass.getPassType() == passType)
        .toList();
    return new StudyCafePassList(list);
  }

  public static StudyCafePassList of(List<StudyCafePass> passes) {
    return new StudyCafePassList(passes);
  }

  public int size() {
    return passes.size();
  }

  public StudyCafePass get(int index) {
    return passes.get(index);
  }
}
