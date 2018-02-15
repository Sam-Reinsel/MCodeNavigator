package net.apjanke.mprojectnavigator.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import com.mathworks.jmi.Matlab;

import static java.util.Objects.requireNonNull;

/**
 * An Action which performs an mtFeval() upon invocation.
 *
 * This is used in the construction of hybrid Matlab/Java Swing GUIs.
 *
 * FevalAction objects are configurable via their state, to avoid the need to
 * define Java subclasses from it.
 */
public class FevalAction extends AbstractAction {
    final String functionName;
    final Object[] functionArgs;
    final int nFunctionOutputs;

    private boolean displayConsoleOutput = false;

    public FevalAction(String functionName, Object[] functionArgs, int nFunctionOutputs) {
        requireNonNull(functionName);
        requireNonNull(functionArgs);
        this.functionName = functionName;
        this.functionArgs = functionArgs;
        this.nFunctionOutputs = nFunctionOutputs;
    }

    public FevalAction(String functionName, Object[] functionArgs) {
        this(functionName, functionArgs, 0);
    }

    public FevalAction(String functionName) {
        this(functionName, new Object[0], 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        invokeFunction();
    }

    public void invokeFunction() {
        try {
            Matlab ml = new Matlab();
            if (isDisplayConsoleOutput()) {
                ml.fevalConsoleOutput(functionName, functionArgs);
            } else {
                ml.fevalNoOutput(functionName, functionArgs);
            }
            //System.err.format("FevalAction.invokeFunction(): success: %s(%s)\n", functionName, functionArgs);
        } catch (Exception err) {
            System.err.println("Error in FevalAction callback");
            System.err.format("  Failed calling %s with arguments %s, %d outputs",
                    functionName, functionArgs, nFunctionOutputs);
            err.printStackTrace();
        }
    }

    public boolean isDisplayConsoleOutput() {
        return displayConsoleOutput;
    }

    public void setDisplayConsoleOutput(boolean displayConsoleOutput) {
        this.displayConsoleOutput = displayConsoleOutput;
    }

    public static FevalAction ofStringArguments(String functionName, String[] functionArgs) {
        Object[] args = new Object[functionArgs.length];
        for (int i = 0; i < functionArgs.length; i++) {
            args[i] = functionArgs[i];
        }
        return new FevalAction(functionName, args);
    }
}
