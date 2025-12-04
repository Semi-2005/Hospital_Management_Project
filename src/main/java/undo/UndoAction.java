package undo;

public class UndoAction {
    private ActionType actionType;
    private Object data;

    public UndoAction(ActionType actionType, Object data) {
        this.actionType = actionType;
        this.data = data;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public Object getData() {
        return data;
    }
}
