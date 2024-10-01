package soma.edupimeta.classroom.account.service.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import soma.edupimeta.classroom.account.exception.ClassroomAccountErrorEnum;
import soma.edupimeta.classroom.account.exception.ClassroomAccountException;

@Getter
public enum ActionStatus {
    ING(0), HELP(1), COMPLETE(2);

    private final int value;

    ActionStatus(int value) {
        this.value = value;
    }

    @JsonCreator
    public static ActionStatus fromValue(int value) {
        for (ActionStatus actionStatus : ActionStatus.values()) {
            if (actionStatus.getValue() == value) {
                return actionStatus;
            }
        }
        throw new ClassroomAccountException(ClassroomAccountErrorEnum.INVALID_VALUE);
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}
