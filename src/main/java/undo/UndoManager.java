package undo;

public class UndoManager {
    private data_structures.stack.MyStack stack;
    private boolean isUndoing = false;

    public UndoManager() {
        this.stack = new data_structures.stack.MyStack();
    }

    // Record a new undoable action
    public void record(ActionType actionType, Object data) {
        if (isUndoing) {
            return;
        }

        UndoAction action = new UndoAction(actionType, data);
        stack.push(action);
    }
    public void setUndoing(boolean status) {
        this.isUndoing = status;
    }
    // Undo the last action and return it
    public UndoAction undo() {
        if (stack.isEmpty()) {
            return null;
        }
        return (UndoAction) stack.pop();
    }

    public boolean hasUndo() {
        return !stack.isEmpty();
    }
}
