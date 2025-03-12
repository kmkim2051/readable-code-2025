package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.io.InputHandler;
import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.io.StudyCafeFileHandler;
import cleancode.studycafe.tobe.model.StudyCafePassType;

import cleancode.studycafe.tobe.runner.impl.FixedPassTypeRunner;
import cleancode.studycafe.tobe.runner.impl.HourlyPassTypeRunner;
import cleancode.studycafe.tobe.runner.impl.WeeklyPassTypeRunner;

public class StudyCafePassMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    private final StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();


    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();
            outputHandler.askPassTypeSelection();
            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();

            if (studyCafePassType == StudyCafePassType.HOURLY) {
                HourlyPassTypeRunner runner = new HourlyPassTypeRunner(studyCafeFileHandler, inputHandler, outputHandler);
                runner.run();
            } else if (studyCafePassType == StudyCafePassType.WEEKLY) {
                WeeklyPassTypeRunner runner = new WeeklyPassTypeRunner(studyCafeFileHandler, inputHandler, outputHandler);
                runner.run();
            } else if (studyCafePassType == StudyCafePassType.FIXED) {
                FixedPassTypeRunner runner = new FixedPassTypeRunner(studyCafeFileHandler, inputHandler, outputHandler);
                runner.run();
            }
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

}
