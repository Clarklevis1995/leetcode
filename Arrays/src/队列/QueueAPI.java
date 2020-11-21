package 队列;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.LinkedList;
import java.util.Queue;

public class QueueAPI {
    public static void main(String[] args) {

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        for (ThreadInfo threadInfo: threadInfos) {
            System.out.println("["+threadInfo.getThreadId()+"]"+threadInfo.getThreadName());
        }

    }
}
