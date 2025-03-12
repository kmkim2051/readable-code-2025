package cleancode.studycafe.tobe.model.collection;

import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePass;
import java.util.List;

public class StudyCafeLockerPassList {
  private final List<StudyCafeLockerPass> passes;

  private StudyCafeLockerPassList(List<StudyCafeLockerPass> passes) {
    this.passes = passes;
  }

  public StudyCafeLockerPass getSelectedPath(StudyCafePass pass) {
    return passes.stream()
        .filter(option ->
            option.getPassType() == pass.getPassType()
                && option.getDuration() == pass.getDuration()
        )
        .findFirst()
        .orElse(null);
  }

  public static StudyCafeLockerPassList of(List<StudyCafeLockerPass> passes) {
    return new StudyCafeLockerPassList(passes);
  }

  public int size() {
    return passes.size();
  }

  public StudyCafeLockerPass get(int index) {
    return passes.get(index);
  }
}
