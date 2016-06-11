# GC

- test for unreachable but not live

## run command

'''
java -cp . -verbose:gc -XX:+PrintGCDetails -Xloggc:gc.log com.codegraphy.MemoryLeak
'''

## gc log

'''
...
10.612: [GC [PSYoungGen: 61952K->0K(87040K)] 88931K->26979K(261632K), 0.0095120 secs] [Times: user=0.07 sys=0.00, real=0.01 secs]
11.462: [GC [PSYoungGen: 78848K->64K(87040K)] 105827K->51080K(261632K), 0.0381440 secs] [Times: user=0.29 sys=0.01, real=0.04 secs]
12.862: [GC [PSYoungGen: 78912K->0K(87040K)] 129928K->51016K(261632K), 0.0103730 secs] [Times: user=0.06 sys=0.00, real=0.01 secs]
14.126: [GC [PSYoungGen: 79872K->0K(87552K)] 130888K->51016K(262144K), 0.0110300 secs] [Times: user=0.07 sys=0.00, real=0.01 secs]
15.380: [GC [PSYoungGen: 79872K->32K(87552K)] 130888K->51048K(262144K), 0.0112240 secs] [Times: user=0.07 sys=0.00, real=0.01 secs]
16.067: [GC [PSYoungGen: 45508K->0K(88064K)] 96524K->51016K(262656K), 0.0113790 secs] [Times: user=0.08 sys=0.00, real=0.01 secs]
16.756: [GC [PSYoungGen: 80896K->32K(89088K)] 131912K->87103K(263680K), 0.0583280 secs] [Times: user=0.43 sys=0.01, real=0.05 secs]
18.078: [GC [PSYoungGen: 82464K->32K(89088K)] 169535K->87103K(263680K), 0.0267570 secs] [Times: user=0.20 sys=0.00, real=0.03 secs]
19.380: [GC [PSYoungGen: 82464K->0K(89088K)] 169535K->87071K(263680K), 0.0248670 secs] [Times: user=0.19 sys=0.00, real=0.03 secs]
20.704: [GC [PSYoungGen: 83456K->0K(89088K)] 170527K->87071K(263680K), 0.0261270 secs] [Times: user=0.16 sys=0.00, real=0.03 secs]
22.094: [GC [PSYoungGen: 83456K->32K(89600K)] 170527K->87103K(264192K), 0.0261130 secs] [Times: user=0.19 sys=0.00, real=0.03 secs]
23.643: [GC [PSYoungGen: 85024K->0K(90112K)] 226178K->141154K(264704K), 0.0268600 secs] [Times: user=0.20 sys=0.00, real=0.03 secs]
25.304: [GC [PSYoungGen: 84992K->0K(91136K)] 226146K->141154K(265728K), 0.0311620 secs] [Times: user=0.22 sys=0.00, real=0.04 secs]
26.978: [GC [PSYoungGen: 86528K->0K(91136K)] 227682K->141154K(265728K), 0.0270550 secs] [Times: user=0.18 sys=0.00, real=0.03 secs]
28.719: [GC [PSYoungGen: 86528K->0K(91136K)] 227682K->141154K(265728K), 0.0273990 secs] [Times: user=0.20 sys=0.00, real=0.03 secs]
30.471: [GC [PSYoungGen: 87040K->0K(91136K)] 228194K->141154K(265728K), 0.0279690 secs] [Times: user=0.21 sys=0.00, real=0.03 secs]
32.297: [GC [PSYoungGen: 87040K->0K(91648K)] 228194K->141154K(266240K), 0.0345120 secs] [Times: user=0.25 sys=0.00, real=0.03 secs]
34.207: [GC [PSYoungGen: 88064K->0K(91648K)] 229218K->141154K(266240K), 0.0278890 secs] [Times: user=0.21 sys=0.00, real=0.03 secs]
36.304: [GC [PSYoungGen: 88064K->32K(92160K)] 229218K->141186K(266752K), 0.0354540 secs] [Times: user=0.24 sys=0.00, real=0.04 secs]
38.092: [GC [PSYoungGen: 73512K->0K(92160K)] 214666K->141154K(284672K), 0.0369820 secs] [Times: user=0.20 sys=0.00, real=0.04 secs]
38.416: [GC-- [PSYoungGen: 89088K->89088K(92160K)] 230242K->230242K(284672K), 0.0343180 secs] [Times: user=0.25 sys=0.01, real=0.03 secs]
38.450: [Full GC [PSYoungGen: 89088K->0K(92160K)] [ParOldGen: 141154K->81357K(180224K)] 230242K->81357K(272384K) [PSPermGen: 2623K->2622K(21504K)], 0.4838040 secs] [Times: user=1.29 sys=0.01, real=0.48 secs]
41.140: [GC [PSYoungGen: 89088K->0K(92160K)] 170445K->81357K(272384K), 0.0308740 secs] [Times: user=0.18 sys=0.00, real=0.03 secs]
43.510: [GC [PSYoungGen: 90112K->64K(92672K)] 171469K->81421K(272896K), 0.0312510 secs] [Times: user=0.23 sys=0.00, real=0.03 secs]
45.918: [GC [PSYoungGen: 90176K->64K(93696K)] 171533K->81421K(273920K), 0.0313520 secs] [Times: user=0.23 sys=0.00, real=0.03 secs]
48.320: [GC [PSYoungGen: 91200K->64K(91648K)] 172557K->81421K(271872K), 0.0318230 secs] [Times: user=0.23 sys=0.00, real=0.03 secs]
50.814: [GC [PSYoungGen: 91200K->0K(93184K)] 172557K->81357K(273408K), 0.0322400 secs] [Times: user=0.25 sys=0.00, real=0.04 secs]
53.370: [GC [PSYoungGen: 91136K->0K(93184K)] 172493K->81357K(273408K), 0.0332930 secs] [Times: user=0.24 sys=0.01, real=0.03 secs]
55.936: [GC [PSYoungGen: 91136K->0K(93184K)] 172493K->81357K(273408K), 0.0358370 secs] [Times: user=0.20 sys=0.00, real=0.03 secs]
58.436: [GC [PSYoungGen: 92160K->0K(93696K)] 173517K->81357K(273920K), 0.0357550 secs] [Times: user=0.23 sys=0.00, real=0.03 secs]
61.021: [GC [PSYoungGen: 92160K->0K(94720K)] 173517K->81357K(274944K), 0.0352470 secs] [Times: user=0.25 sys=0.00, real=0.04 secs]
63.780: [GC [PSYoungGen: 93184K->0K(94720K)] 174541K->81357K(274944K), 0.0363320 secs] [Times: user=0.22 sys=0.01, real=0.04 secs]
66.634: [GC [PSYoungGen: 93184K->64K(94720K)] 174541K->81421K(274944K), 0.0375520 secs] [Times: user=0.23 sys=0.01, real=0.04 secs]
67.119: [GC [PSYoungGen: 16943K->0K(93696K)] 98301K->81357K(286208K), 0.0367150 secs] [Times: user=0.27 sys=0.00, real=0.04 secs]
67.155: [GC [PSYoungGen: 0K->0K(94208K)] 81357K->81357K(286720K), 0.0384290 secs] [Times: user=0.24 sys=0.01, real=0.03 secs]
67.194: [Full GC [PSYoungGen: 0K->0K(94208K)] [ParOldGen: 81357K->81357K(177152K)] 81357K->81357K(271360K) [PSPermGen: 2622K->2622K(21504K)], 0.3068460 secs] [Times: user=2.19 sys=0.03, real=0.31 secs]
67.501: [GC [PSYoungGen: 0K->0K(94208K)] 81357K->81357K(286720K), 0.0005090 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
67.501: [Full GC [PSYoungGen: 0K->0K(94208K)] [ParOldGen: 81357K->81346K(192512K)] 81357K->81346K(286720K) [PSPermGen: 2622K->2622K(21504K)], 0.6331830 secs] [Times: user=1.57 sys=0.02, real=0.64 secs]
Heap
 PSYoungGen      total 94208K, used 3739K [0x00000007fa200000, 0x0000000800000000, 0x0000000800000000)
  eden space 93184K, 4% used [0x00000007fa200000,0x00000007fa5a6d28,0x00000007ffd00000)
  from space 1024K, 0% used [0x00000007ffd00000,0x00000007ffd00000,0x00000007ffe00000)
  to   space 1024K, 0% used [0x00000007fff00000,0x00000007fff00000,0x0000000800000000)
 ParOldGen       total 192512K, used 81346K [0x00000007ee600000, 0x00000007fa200000, 0x00000007fa200000)
  object space 192512K, 42% used [0x00000007ee600000,0x00000007f3570930,0x00000007fa200000)
 PSPermGen       total 21504K, used 2653K [0x00000007e9400000, 0x00000007ea900000, 0x00000007ee600000)
  object space 21504K, 12% used [0x00000007e9400000,0x00000007e9697718,0x00000007ea900000)
'''

## console output

'''
...
9230096
9230097
9230098
9230099
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:2245)
	at java.util.Arrays.copyOf(Arrays.java:2219)
	at java.util.ArrayList.grow(ArrayList.java:242)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:216)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:208)
	at java.util.ArrayList.add(ArrayList.java:440)
	at com.codegraphy.MemoryLeak.main(MemoryLeak.java:12)
'''
