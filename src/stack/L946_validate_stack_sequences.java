package stack;

public class L946_validate_stack_sequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushIdx = 0, popIdx = 0;

        for (int i = 0; i < pushed.length; i++) {
            pushed[pushIdx] = pushed[i];

            while (pushIdx >= 0 && pushed[pushIdx] == popped[popIdx]) {
                pushIdx--;
                popIdx++;
            }

            pushIdx++;
        }

        return pushIdx == 0 && popIdx == popped.length;
    }
}
