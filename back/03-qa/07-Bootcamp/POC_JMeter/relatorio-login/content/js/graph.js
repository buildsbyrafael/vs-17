/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
$(document).ready(function() {

    $(".click-title").mouseenter( function(    e){
        e.preventDefault();
        this.style.cursor="pointer";
    });
    $(".click-title").mousedown( function(event){
        event.preventDefault();
    });

    // Ugly code while this script is shared among several pages
    try{
        refreshHitsPerSecond(true);
    } catch(e){}
    try{
        refreshResponseTimeOverTime(true);
    } catch(e){}
    try{
        refreshResponseTimePercentiles();
    } catch(e){}
});


var responseTimePercentilesInfos = {
        data: {"result": {"minY": 14.0, "minX": 0.0, "maxY": 1392.0, "series": [{"data": [[0.0, 14.0], [0.1, 37.0], [0.2, 62.0], [0.3, 68.0], [0.4, 79.0], [0.5, 80.0], [0.6, 84.0], [0.7, 87.0], [0.8, 93.0], [0.9, 101.0], [1.0, 105.0], [1.1, 116.0], [1.2, 125.0], [1.3, 129.0], [1.4, 143.0], [1.5, 150.0], [1.6, 156.0], [1.7, 161.0], [1.8, 163.0], [1.9, 167.0], [2.0, 173.0], [2.1, 178.0], [2.2, 190.0], [2.3, 205.0], [2.4, 211.0], [2.5, 218.0], [2.6, 224.0], [2.7, 232.0], [2.8, 241.0], [2.9, 249.0], [3.0, 254.0], [3.1, 258.0], [3.2, 261.0], [3.3, 273.0], [3.4, 287.0], [3.5, 294.0], [3.6, 313.0], [3.7, 326.0], [3.8, 354.0], [3.9, 364.0], [4.0, 401.0], [4.1, 409.0], [4.2, 416.0], [4.3, 434.0], [4.4, 448.0], [4.5, 455.0], [4.6, 474.0], [4.7, 482.0], [4.8, 501.0], [4.9, 511.0], [5.0, 513.0], [5.1, 518.0], [5.2, 523.0], [5.3, 526.0], [5.4, 527.0], [5.5, 538.0], [5.6, 545.0], [5.7, 550.0], [5.8, 556.0], [5.9, 562.0], [6.0, 564.0], [6.1, 567.0], [6.2, 571.0], [6.3, 573.0], [6.4, 574.0], [6.5, 577.0], [6.6, 580.0], [6.7, 583.0], [6.8, 588.0], [6.9, 591.0], [7.0, 594.0], [7.1, 600.0], [7.2, 607.0], [7.3, 612.0], [7.4, 614.0], [7.5, 620.0], [7.6, 623.0], [7.7, 626.0], [7.8, 630.0], [7.9, 639.0], [8.0, 642.0], [8.1, 658.0], [8.2, 684.0], [8.3, 690.0], [8.4, 693.0], [8.5, 696.0], [8.6, 698.0], [8.7, 701.0], [8.8, 704.0], [8.9, 708.0], [9.0, 712.0], [9.1, 723.0], [9.2, 734.0], [9.3, 755.0], [9.4, 759.0], [9.5, 762.0], [9.6, 767.0], [9.7, 768.0], [9.8, 771.0], [9.9, 774.0], [10.0, 776.0], [10.1, 777.0], [10.2, 778.0], [10.3, 780.0], [10.4, 781.0], [10.5, 782.0], [10.6, 783.0], [10.7, 784.0], [10.8, 785.0], [10.9, 785.0], [11.0, 786.0], [11.1, 787.0], [11.2, 787.0], [11.3, 788.0], [11.4, 789.0], [11.5, 789.0], [11.6, 790.0], [11.7, 791.0], [11.8, 791.0], [11.9, 792.0], [12.0, 792.0], [12.1, 793.0], [12.2, 794.0], [12.3, 795.0], [12.4, 795.0], [12.5, 796.0], [12.6, 796.0], [12.7, 797.0], [12.8, 798.0], [12.9, 798.0], [13.0, 799.0], [13.1, 799.0], [13.2, 800.0], [13.3, 800.0], [13.4, 800.0], [13.5, 801.0], [13.6, 801.0], [13.7, 802.0], [13.8, 803.0], [13.9, 803.0], [14.0, 804.0], [14.1, 805.0], [14.2, 805.0], [14.3, 806.0], [14.4, 807.0], [14.5, 807.0], [14.6, 807.0], [14.7, 808.0], [14.8, 808.0], [14.9, 808.0], [15.0, 809.0], [15.1, 809.0], [15.2, 810.0], [15.3, 810.0], [15.4, 811.0], [15.5, 811.0], [15.6, 811.0], [15.7, 812.0], [15.8, 813.0], [15.9, 813.0], [16.0, 814.0], [16.1, 815.0], [16.2, 815.0], [16.3, 816.0], [16.4, 817.0], [16.5, 817.0], [16.6, 818.0], [16.7, 818.0], [16.8, 819.0], [16.9, 819.0], [17.0, 820.0], [17.1, 820.0], [17.2, 821.0], [17.3, 821.0], [17.4, 822.0], [17.5, 822.0], [17.6, 823.0], [17.7, 823.0], [17.8, 824.0], [17.9, 824.0], [18.0, 825.0], [18.1, 825.0], [18.2, 826.0], [18.3, 826.0], [18.4, 827.0], [18.5, 827.0], [18.6, 828.0], [18.7, 829.0], [18.8, 829.0], [18.9, 830.0], [19.0, 830.0], [19.1, 831.0], [19.2, 832.0], [19.3, 832.0], [19.4, 833.0], [19.5, 833.0], [19.6, 834.0], [19.7, 835.0], [19.8, 835.0], [19.9, 836.0], [20.0, 836.0], [20.1, 837.0], [20.2, 837.0], [20.3, 837.0], [20.4, 838.0], [20.5, 838.0], [20.6, 839.0], [20.7, 839.0], [20.8, 839.0], [20.9, 840.0], [21.0, 840.0], [21.1, 840.0], [21.2, 841.0], [21.3, 841.0], [21.4, 841.0], [21.5, 842.0], [21.6, 842.0], [21.7, 843.0], [21.8, 843.0], [21.9, 843.0], [22.0, 844.0], [22.1, 844.0], [22.2, 844.0], [22.3, 845.0], [22.4, 845.0], [22.5, 845.0], [22.6, 846.0], [22.7, 846.0], [22.8, 846.0], [22.9, 846.0], [23.0, 847.0], [23.1, 847.0], [23.2, 847.0], [23.3, 848.0], [23.4, 848.0], [23.5, 849.0], [23.6, 849.0], [23.7, 850.0], [23.8, 850.0], [23.9, 850.0], [24.0, 851.0], [24.1, 851.0], [24.2, 851.0], [24.3, 852.0], [24.4, 853.0], [24.5, 853.0], [24.6, 853.0], [24.7, 854.0], [24.8, 854.0], [24.9, 854.0], [25.0, 855.0], [25.1, 855.0], [25.2, 856.0], [25.3, 856.0], [25.4, 857.0], [25.5, 857.0], [25.6, 858.0], [25.7, 858.0], [25.8, 858.0], [25.9, 859.0], [26.0, 859.0], [26.1, 860.0], [26.2, 860.0], [26.3, 860.0], [26.4, 861.0], [26.5, 861.0], [26.6, 861.0], [26.7, 861.0], [26.8, 862.0], [26.9, 862.0], [27.0, 862.0], [27.1, 863.0], [27.2, 863.0], [27.3, 863.0], [27.4, 864.0], [27.5, 864.0], [27.6, 865.0], [27.7, 865.0], [27.8, 865.0], [27.9, 865.0], [28.0, 865.0], [28.1, 866.0], [28.2, 866.0], [28.3, 866.0], [28.4, 867.0], [28.5, 867.0], [28.6, 867.0], [28.7, 868.0], [28.8, 868.0], [28.9, 868.0], [29.0, 868.0], [29.1, 868.0], [29.2, 869.0], [29.3, 869.0], [29.4, 869.0], [29.5, 870.0], [29.6, 870.0], [29.7, 871.0], [29.8, 871.0], [29.9, 871.0], [30.0, 871.0], [30.1, 871.0], [30.2, 872.0], [30.3, 872.0], [30.4, 872.0], [30.5, 873.0], [30.6, 873.0], [30.7, 873.0], [30.8, 874.0], [30.9, 874.0], [31.0, 874.0], [31.1, 874.0], [31.2, 875.0], [31.3, 875.0], [31.4, 875.0], [31.5, 875.0], [31.6, 876.0], [31.7, 876.0], [31.8, 876.0], [31.9, 877.0], [32.0, 877.0], [32.1, 877.0], [32.2, 877.0], [32.3, 878.0], [32.4, 878.0], [32.5, 878.0], [32.6, 878.0], [32.7, 878.0], [32.8, 879.0], [32.9, 879.0], [33.0, 879.0], [33.1, 879.0], [33.2, 880.0], [33.3, 880.0], [33.4, 880.0], [33.5, 880.0], [33.6, 881.0], [33.7, 881.0], [33.8, 881.0], [33.9, 881.0], [34.0, 881.0], [34.1, 882.0], [34.2, 882.0], [34.3, 882.0], [34.4, 882.0], [34.5, 883.0], [34.6, 883.0], [34.7, 883.0], [34.8, 883.0], [34.9, 884.0], [35.0, 884.0], [35.1, 884.0], [35.2, 884.0], [35.3, 885.0], [35.4, 885.0], [35.5, 885.0], [35.6, 885.0], [35.7, 886.0], [35.8, 886.0], [35.9, 886.0], [36.0, 886.0], [36.1, 886.0], [36.2, 887.0], [36.3, 887.0], [36.4, 887.0], [36.5, 887.0], [36.6, 888.0], [36.7, 888.0], [36.8, 888.0], [36.9, 888.0], [37.0, 888.0], [37.1, 889.0], [37.2, 889.0], [37.3, 889.0], [37.4, 890.0], [37.5, 890.0], [37.6, 890.0], [37.7, 890.0], [37.8, 890.0], [37.9, 891.0], [38.0, 891.0], [38.1, 891.0], [38.2, 891.0], [38.3, 892.0], [38.4, 892.0], [38.5, 892.0], [38.6, 892.0], [38.7, 892.0], [38.8, 893.0], [38.9, 893.0], [39.0, 893.0], [39.1, 893.0], [39.2, 893.0], [39.3, 894.0], [39.4, 894.0], [39.5, 894.0], [39.6, 895.0], [39.7, 895.0], [39.8, 895.0], [39.9, 895.0], [40.0, 895.0], [40.1, 895.0], [40.2, 896.0], [40.3, 896.0], [40.4, 896.0], [40.5, 896.0], [40.6, 897.0], [40.7, 897.0], [40.8, 897.0], [40.9, 898.0], [41.0, 898.0], [41.1, 898.0], [41.2, 898.0], [41.3, 898.0], [41.4, 899.0], [41.5, 899.0], [41.6, 899.0], [41.7, 899.0], [41.8, 899.0], [41.9, 899.0], [42.0, 900.0], [42.1, 900.0], [42.2, 900.0], [42.3, 900.0], [42.4, 901.0], [42.5, 901.0], [42.6, 901.0], [42.7, 901.0], [42.8, 901.0], [42.9, 902.0], [43.0, 902.0], [43.1, 902.0], [43.2, 902.0], [43.3, 903.0], [43.4, 903.0], [43.5, 903.0], [43.6, 903.0], [43.7, 904.0], [43.8, 904.0], [43.9, 904.0], [44.0, 904.0], [44.1, 905.0], [44.2, 905.0], [44.3, 905.0], [44.4, 905.0], [44.5, 906.0], [44.6, 906.0], [44.7, 906.0], [44.8, 907.0], [44.9, 907.0], [45.0, 907.0], [45.1, 907.0], [45.2, 907.0], [45.3, 907.0], [45.4, 907.0], [45.5, 908.0], [45.6, 908.0], [45.7, 908.0], [45.8, 908.0], [45.9, 909.0], [46.0, 909.0], [46.1, 909.0], [46.2, 909.0], [46.3, 910.0], [46.4, 910.0], [46.5, 910.0], [46.6, 910.0], [46.7, 910.0], [46.8, 911.0], [46.9, 911.0], [47.0, 911.0], [47.1, 911.0], [47.2, 912.0], [47.3, 912.0], [47.4, 912.0], [47.5, 913.0], [47.6, 913.0], [47.7, 913.0], [47.8, 914.0], [47.9, 914.0], [48.0, 914.0], [48.1, 914.0], [48.2, 915.0], [48.3, 915.0], [48.4, 915.0], [48.5, 916.0], [48.6, 916.0], [48.7, 917.0], [48.8, 917.0], [48.9, 917.0], [49.0, 917.0], [49.1, 917.0], [49.2, 917.0], [49.3, 918.0], [49.4, 918.0], [49.5, 918.0], [49.6, 919.0], [49.7, 919.0], [49.8, 920.0], [49.9, 920.0], [50.0, 920.0], [50.1, 921.0], [50.2, 921.0], [50.3, 921.0], [50.4, 922.0], [50.5, 922.0], [50.6, 923.0], [50.7, 924.0], [50.8, 924.0], [50.9, 924.0], [51.0, 924.0], [51.1, 925.0], [51.2, 926.0], [51.3, 926.0], [51.4, 927.0], [51.5, 927.0], [51.6, 928.0], [51.7, 928.0], [51.8, 928.0], [51.9, 929.0], [52.0, 929.0], [52.1, 929.0], [52.2, 930.0], [52.3, 930.0], [52.4, 930.0], [52.5, 931.0], [52.6, 931.0], [52.7, 931.0], [52.8, 932.0], [52.9, 932.0], [53.0, 932.0], [53.1, 933.0], [53.2, 933.0], [53.3, 934.0], [53.4, 934.0], [53.5, 935.0], [53.6, 935.0], [53.7, 936.0], [53.8, 936.0], [53.9, 937.0], [54.0, 937.0], [54.1, 938.0], [54.2, 938.0], [54.3, 939.0], [54.4, 939.0], [54.5, 940.0], [54.6, 940.0], [54.7, 940.0], [54.8, 941.0], [54.9, 942.0], [55.0, 942.0], [55.1, 943.0], [55.2, 944.0], [55.3, 944.0], [55.4, 945.0], [55.5, 945.0], [55.6, 946.0], [55.7, 946.0], [55.8, 947.0], [55.9, 947.0], [56.0, 948.0], [56.1, 948.0], [56.2, 948.0], [56.3, 949.0], [56.4, 950.0], [56.5, 950.0], [56.6, 950.0], [56.7, 951.0], [56.8, 952.0], [56.9, 952.0], [57.0, 953.0], [57.1, 953.0], [57.2, 953.0], [57.3, 954.0], [57.4, 954.0], [57.5, 955.0], [57.6, 955.0], [57.7, 955.0], [57.8, 956.0], [57.9, 956.0], [58.0, 956.0], [58.1, 957.0], [58.2, 957.0], [58.3, 957.0], [58.4, 958.0], [58.5, 958.0], [58.6, 959.0], [58.7, 959.0], [58.8, 960.0], [58.9, 960.0], [59.0, 961.0], [59.1, 962.0], [59.2, 962.0], [59.3, 962.0], [59.4, 963.0], [59.5, 963.0], [59.6, 964.0], [59.7, 964.0], [59.8, 964.0], [59.9, 965.0], [60.0, 965.0], [60.1, 965.0], [60.2, 966.0], [60.3, 966.0], [60.4, 967.0], [60.5, 967.0], [60.6, 967.0], [60.7, 968.0], [60.8, 968.0], [60.9, 969.0], [61.0, 969.0], [61.1, 969.0], [61.2, 969.0], [61.3, 970.0], [61.4, 970.0], [61.5, 970.0], [61.6, 971.0], [61.7, 971.0], [61.8, 972.0], [61.9, 972.0], [62.0, 973.0], [62.1, 973.0], [62.2, 974.0], [62.3, 974.0], [62.4, 975.0], [62.5, 975.0], [62.6, 975.0], [62.7, 975.0], [62.8, 976.0], [62.9, 976.0], [63.0, 977.0], [63.1, 977.0], [63.2, 977.0], [63.3, 978.0], [63.4, 978.0], [63.5, 979.0], [63.6, 980.0], [63.7, 980.0], [63.8, 981.0], [63.9, 981.0], [64.0, 981.0], [64.1, 982.0], [64.2, 982.0], [64.3, 983.0], [64.4, 983.0], [64.5, 983.0], [64.6, 984.0], [64.7, 984.0], [64.8, 984.0], [64.9, 984.0], [65.0, 985.0], [65.1, 985.0], [65.2, 985.0], [65.3, 985.0], [65.4, 986.0], [65.5, 986.0], [65.6, 986.0], [65.7, 986.0], [65.8, 987.0], [65.9, 988.0], [66.0, 988.0], [66.1, 989.0], [66.2, 989.0], [66.3, 990.0], [66.4, 990.0], [66.5, 990.0], [66.6, 991.0], [66.7, 991.0], [66.8, 992.0], [66.9, 992.0], [67.0, 993.0], [67.1, 993.0], [67.2, 993.0], [67.3, 993.0], [67.4, 994.0], [67.5, 995.0], [67.6, 995.0], [67.7, 996.0], [67.8, 996.0], [67.9, 996.0], [68.0, 997.0], [68.1, 997.0], [68.2, 998.0], [68.3, 998.0], [68.4, 999.0], [68.5, 999.0], [68.6, 999.0], [68.7, 1000.0], [68.8, 1000.0], [68.9, 1001.0], [69.0, 1001.0], [69.1, 1001.0], [69.2, 1002.0], [69.3, 1002.0], [69.4, 1002.0], [69.5, 1003.0], [69.6, 1003.0], [69.7, 1004.0], [69.8, 1004.0], [69.9, 1005.0], [70.0, 1005.0], [70.1, 1005.0], [70.2, 1006.0], [70.3, 1006.0], [70.4, 1007.0], [70.5, 1007.0], [70.6, 1007.0], [70.7, 1008.0], [70.8, 1009.0], [70.9, 1009.0], [71.0, 1010.0], [71.1, 1010.0], [71.2, 1010.0], [71.3, 1011.0], [71.4, 1011.0], [71.5, 1012.0], [71.6, 1013.0], [71.7, 1013.0], [71.8, 1014.0], [71.9, 1014.0], [72.0, 1014.0], [72.1, 1014.0], [72.2, 1015.0], [72.3, 1016.0], [72.4, 1016.0], [72.5, 1016.0], [72.6, 1017.0], [72.7, 1017.0], [72.8, 1018.0], [72.9, 1018.0], [73.0, 1018.0], [73.1, 1019.0], [73.2, 1019.0], [73.3, 1020.0], [73.4, 1020.0], [73.5, 1020.0], [73.6, 1021.0], [73.7, 1021.0], [73.8, 1021.0], [73.9, 1022.0], [74.0, 1023.0], [74.1, 1023.0], [74.2, 1023.0], [74.3, 1024.0], [74.4, 1024.0], [74.5, 1025.0], [74.6, 1025.0], [74.7, 1026.0], [74.8, 1026.0], [74.9, 1026.0], [75.0, 1027.0], [75.1, 1027.0], [75.2, 1027.0], [75.3, 1028.0], [75.4, 1028.0], [75.5, 1029.0], [75.6, 1029.0], [75.7, 1029.0], [75.8, 1029.0], [75.9, 1030.0], [76.0, 1030.0], [76.1, 1031.0], [76.2, 1031.0], [76.3, 1032.0], [76.4, 1032.0], [76.5, 1033.0], [76.6, 1033.0], [76.7, 1033.0], [76.8, 1034.0], [76.9, 1034.0], [77.0, 1034.0], [77.1, 1035.0], [77.2, 1035.0], [77.3, 1036.0], [77.4, 1036.0], [77.5, 1037.0], [77.6, 1037.0], [77.7, 1037.0], [77.8, 1038.0], [77.9, 1038.0], [78.0, 1038.0], [78.1, 1039.0], [78.2, 1039.0], [78.3, 1040.0], [78.4, 1040.0], [78.5, 1040.0], [78.6, 1041.0], [78.7, 1041.0], [78.8, 1041.0], [78.9, 1042.0], [79.0, 1042.0], [79.1, 1042.0], [79.2, 1042.0], [79.3, 1043.0], [79.4, 1043.0], [79.5, 1043.0], [79.6, 1043.0], [79.7, 1043.0], [79.8, 1044.0], [79.9, 1044.0], [80.0, 1044.0], [80.1, 1044.0], [80.2, 1045.0], [80.3, 1045.0], [80.4, 1045.0], [80.5, 1046.0], [80.6, 1046.0], [80.7, 1047.0], [80.8, 1047.0], [80.9, 1047.0], [81.0, 1048.0], [81.1, 1048.0], [81.2, 1049.0], [81.3, 1049.0], [81.4, 1049.0], [81.5, 1050.0], [81.6, 1050.0], [81.7, 1050.0], [81.8, 1051.0], [81.9, 1051.0], [82.0, 1051.0], [82.1, 1052.0], [82.2, 1052.0], [82.3, 1052.0], [82.4, 1053.0], [82.5, 1054.0], [82.6, 1054.0], [82.7, 1054.0], [82.8, 1055.0], [82.9, 1055.0], [83.0, 1056.0], [83.1, 1057.0], [83.2, 1057.0], [83.3, 1058.0], [83.4, 1058.0], [83.5, 1058.0], [83.6, 1058.0], [83.7, 1059.0], [83.8, 1059.0], [83.9, 1060.0], [84.0, 1060.0], [84.1, 1061.0], [84.2, 1061.0], [84.3, 1062.0], [84.4, 1062.0], [84.5, 1063.0], [84.6, 1063.0], [84.7, 1063.0], [84.8, 1064.0], [84.9, 1065.0], [85.0, 1065.0], [85.1, 1066.0], [85.2, 1066.0], [85.3, 1067.0], [85.4, 1068.0], [85.5, 1068.0], [85.6, 1069.0], [85.7, 1069.0], [85.8, 1070.0], [85.9, 1070.0], [86.0, 1070.0], [86.1, 1071.0], [86.2, 1071.0], [86.3, 1071.0], [86.4, 1072.0], [86.5, 1072.0], [86.6, 1073.0], [86.7, 1073.0], [86.8, 1074.0], [86.9, 1074.0], [87.0, 1075.0], [87.1, 1075.0], [87.2, 1076.0], [87.3, 1076.0], [87.4, 1077.0], [87.5, 1077.0], [87.6, 1078.0], [87.7, 1078.0], [87.8, 1079.0], [87.9, 1079.0], [88.0, 1080.0], [88.1, 1080.0], [88.2, 1081.0], [88.3, 1081.0], [88.4, 1082.0], [88.5, 1082.0], [88.6, 1083.0], [88.7, 1084.0], [88.8, 1085.0], [88.9, 1085.0], [89.0, 1086.0], [89.1, 1087.0], [89.2, 1087.0], [89.3, 1088.0], [89.4, 1088.0], [89.5, 1089.0], [89.6, 1089.0], [89.7, 1090.0], [89.8, 1090.0], [89.9, 1091.0], [90.0, 1092.0], [90.1, 1092.0], [90.2, 1093.0], [90.3, 1093.0], [90.4, 1094.0], [90.5, 1094.0], [90.6, 1095.0], [90.7, 1095.0], [90.8, 1096.0], [90.9, 1096.0], [91.0, 1096.0], [91.1, 1097.0], [91.2, 1098.0], [91.3, 1098.0], [91.4, 1099.0], [91.5, 1099.0], [91.6, 1100.0], [91.7, 1100.0], [91.8, 1101.0], [91.9, 1102.0], [92.0, 1102.0], [92.1, 1103.0], [92.2, 1104.0], [92.3, 1104.0], [92.4, 1105.0], [92.5, 1106.0], [92.6, 1106.0], [92.7, 1107.0], [92.8, 1107.0], [92.9, 1107.0], [93.0, 1108.0], [93.1, 1108.0], [93.2, 1109.0], [93.3, 1110.0], [93.4, 1111.0], [93.5, 1111.0], [93.6, 1112.0], [93.7, 1114.0], [93.8, 1114.0], [93.9, 1115.0], [94.0, 1116.0], [94.1, 1118.0], [94.2, 1119.0], [94.3, 1121.0], [94.4, 1122.0], [94.5, 1123.0], [94.6, 1124.0], [94.7, 1125.0], [94.8, 1127.0], [94.9, 1128.0], [95.0, 1129.0], [95.1, 1130.0], [95.2, 1132.0], [95.3, 1132.0], [95.4, 1135.0], [95.5, 1137.0], [95.6, 1138.0], [95.7, 1140.0], [95.8, 1141.0], [95.9, 1143.0], [96.0, 1145.0], [96.1, 1145.0], [96.2, 1147.0], [96.3, 1148.0], [96.4, 1149.0], [96.5, 1152.0], [96.6, 1153.0], [96.7, 1156.0], [96.8, 1157.0], [96.9, 1159.0], [97.0, 1161.0], [97.1, 1162.0], [97.2, 1164.0], [97.3, 1165.0], [97.4, 1167.0], [97.5, 1169.0], [97.6, 1171.0], [97.7, 1171.0], [97.8, 1173.0], [97.9, 1175.0], [98.0, 1178.0], [98.1, 1181.0], [98.2, 1183.0], [98.3, 1186.0], [98.4, 1191.0], [98.5, 1194.0], [98.6, 1198.0], [98.7, 1205.0], [98.8, 1210.0], [98.9, 1215.0], [99.0, 1221.0], [99.1, 1230.0], [99.2, 1242.0], [99.3, 1257.0], [99.4, 1268.0], [99.5, 1297.0], [99.6, 1307.0], [99.7, 1337.0], [99.8, 1360.0], [99.9, 1368.0], [100.0, 1392.0]], "isOverall": false, "label": "HTTP Request", "isController": false}], "supportsControllersDiscrimination": true, "maxX": 100.0, "title": "Response Time Percentiles"}},
        getOptions: function() {
            return {
                series: {
                    points: { show: false }
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendResponseTimePercentiles'
                },
                xaxis: {
                    tickDecimals: 1,
                    axisLabel: "Percentiles",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Percentile value in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : %x.2 percentile was %y ms"
                },
                selection: { mode: "xy" },
            };
        },
        createGraph: function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesResponseTimePercentiles"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotResponseTimesPercentiles"), dataset, options);
            // setup overview
            $.plot($("#overviewResponseTimesPercentiles"), dataset, prepareOverviewOptions(options));
        }
};

/**
 * @param elementId Id of element where we display message
 */
function setEmptyGraph(elementId) {
    $(function() {
        $(elementId).text("No graph series with filter="+seriesFilter);
    });
}

// Response times percentiles
function refreshResponseTimePercentiles() {
    var infos = responseTimePercentilesInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyResponseTimePercentiles");
        return;
    }
    if (isGraph($("#flotResponseTimesPercentiles"))){
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesResponseTimePercentiles");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimesPercentiles", "#overviewResponseTimesPercentiles");
        $('#bodyResponseTimePercentiles .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
}

var responseTimeDistributionInfos = {
        data: {"result": {"minY": 31.0, "minX": 0.0, "maxY": 1833.0, "series": [{"data": [[0.0, 56.0], [600.0, 100.0], [700.0, 287.0], [200.0, 79.0], [800.0, 1833.0], [900.0, 1698.0], [1000.0, 1459.0], [1100.0, 449.0], [300.0, 31.0], [1200.0, 57.0], [1300.0, 31.0], [100.0, 88.0], [400.0, 50.0], [500.0, 146.0]], "isOverall": false, "label": "HTTP Request", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 100, "maxX": 1300.0, "title": "Response Time Distribution"}},
        getOptions: function() {
            var granularity = this.data.result.granularity;
            return {
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendResponseTimeDistribution'
                },
                xaxis:{
                    axisLabel: "Response times in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of responses",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                bars : {
                    show: true,
                    barWidth: this.data.result.granularity
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: function(label, xval, yval, flotItem){
                        return yval + " responses for " + label + " were between " + xval + " and " + (xval + granularity) + " ms";
                    }
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotResponseTimeDistribution"), prepareData(data.result.series, $("#choicesResponseTimeDistribution")), options);
        }

};

// Response time distribution
function refreshResponseTimeDistribution() {
    var infos = responseTimeDistributionInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyResponseTimeDistribution");
        return;
    }
    if (isGraph($("#flotResponseTimeDistribution"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesResponseTimeDistribution");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        $('#footerResponseTimeDistribution .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};


var syntheticResponseTimeDistributionInfos = {
        data: {"result": {"minY": 102.0, "minX": 0.0, "ticks": [[0, "Requests having \nresponse time <= 500ms"], [1, "Requests having \nresponse time > 500ms and <= 1,500ms"], [2, "Requests having \nresponse time > 1,500ms"], [3, "Requests in error"]], "maxY": 4243.0, "series": [{"data": [[0.0, 102.0]], "color": "#9ACD32", "isOverall": false, "label": "Requests having \nresponse time <= 500ms", "isController": false}, {"data": [[1.0, 2019.0]], "color": "yellow", "isOverall": false, "label": "Requests having \nresponse time > 500ms and <= 1,500ms", "isController": false}, {"data": [], "color": "orange", "isOverall": false, "label": "Requests having \nresponse time > 1,500ms", "isController": false}, {"data": [[3.0, 4243.0]], "color": "#FF6347", "isOverall": false, "label": "Requests in error", "isController": false}], "supportsControllersDiscrimination": false, "maxX": 3.0, "title": "Synthetic Response Times Distribution"}},
        getOptions: function() {
            return {
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendSyntheticResponseTimeDistribution'
                },
                xaxis:{
                    axisLabel: "Response times ranges",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                    tickLength:0,
                    min:-0.5,
                    max:3.5
                },
                yaxis: {
                    axisLabel: "Number of responses",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                bars : {
                    show: true,
                    align: "center",
                    barWidth: 0.25,
                    fill:.75
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: function(label, xval, yval, flotItem){
                        return yval + " " + label;
                    }
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var options = this.getOptions();
            prepareOptions(options, data);
            options.xaxis.ticks = data.result.ticks;
            $.plot($("#flotSyntheticResponseTimeDistribution"), prepareData(data.result.series, $("#choicesSyntheticResponseTimeDistribution")), options);
        }

};

// Response time distribution
function refreshSyntheticResponseTimeDistribution() {
    var infos = syntheticResponseTimeDistributionInfos;
    prepareSeries(infos.data, true);
    if (isGraph($("#flotSyntheticResponseTimeDistribution"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesSyntheticResponseTimeDistribution");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        $('#footerSyntheticResponseTimeDistribution .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var activeThreadsOverTimeInfos = {
        data: {"result": {"minY": 41.85842831433715, "minX": 1.77030048E12, "maxY": 50.0, "series": [{"data": [[1.7703006E12, 49.21069587628869], [1.77030048E12, 41.85842831433715], [1.77030054E12, 50.0]], "isOverall": false, "label": "Thread Group", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.7703006E12, "title": "Active Threads Over Time"}},
        getOptions: function() {
            return {
                series: {
                    stack: true,
                    lines: {
                        show: true,
                        fill: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of active threads",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: {
                    noColumns: 6,
                    show: true,
                    container: '#legendActiveThreadsOverTime'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                selection: {
                    mode: 'xy'
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : At %x there were %y active threads"
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesActiveThreadsOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotActiveThreadsOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewActiveThreadsOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Active Threads Over Time
function refreshActiveThreadsOverTime(fixTimestamps) {
    var infos = activeThreadsOverTimeInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if(isGraph($("#flotActiveThreadsOverTime"))) {
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesActiveThreadsOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotActiveThreadsOverTime", "#overviewActiveThreadsOverTime");
        $('#footerActiveThreadsOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var timeVsThreadsInfos = {
        data: {"result": {"minY": 121.4, "minX": 1.0, "maxY": 956.4440772308237, "series": [{"data": [[2.0, 121.4], [3.0, 130.8181818181818], [4.0, 185.0], [5.0, 151.91666666666669], [6.0, 132.73333333333335], [7.0, 153.57142857142858], [8.0, 175.0], [9.0, 196.57142857142856], [10.0, 182.5], [11.0, 215.15384615384616], [12.0, 212.42857142857144], [13.0, 221.4666666666667], [14.0, 254.84615384615387], [15.0, 259.3571428571429], [16.0, 302.25], [17.0, 278.6666666666667], [18.0, 290.92857142857144], [19.0, 314.53846153846155], [20.0, 336.99999999999994], [21.0, 362.00000000000006], [22.0, 399.50000000000006], [23.0, 442.8], [24.0, 445.07692307692304], [25.0, 497.375], [26.0, 523.0909090909091], [27.0, 604.875], [28.0, 640.1111111111111], [29.0, 648.8181818181819], [30.0, 565.6666666666666], [31.0, 481.2307692307692], [32.0, 528.8888888888889], [33.0, 600.1], [34.0, 639.0000000000001], [35.0, 606.7857142857143], [36.0, 542.8], [37.0, 542.0714285714286], [38.0, 550.1428571428572], [39.0, 575.8461538461538], [40.0, 585.0000000000001], [41.0, 590.2666666666665], [42.0, 597.7142857142858], [43.0, 604.5714285714286], [44.0, 628.3333333333334], [45.0, 655.6666666666666], [46.0, 688.0714285714286], [47.0, 710.3076923076923], [48.0, 706.6666666666665], [49.0, 710.0], [50.0, 956.4440772308237], [1.0, 477.5]], "isOverall": false, "label": "HTTP Request", "isController": false}, {"data": [[47.67489000628556, 905.9789440603414]], "isOverall": false, "label": "HTTP Request-Aggregated", "isController": false}], "supportsControllersDiscrimination": true, "maxX": 50.0, "title": "Time VS Threads"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    axisLabel: "Number of active threads",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Average response times in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: { noColumns: 2,show: true, container: '#legendTimeVsThreads' },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s: At %x.2 active threads, Average response time was %y.2 ms"
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesTimeVsThreads"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotTimesVsThreads"), dataset, options);
            // setup overview
            $.plot($("#overviewTimesVsThreads"), dataset, prepareOverviewOptions(options));
        }
};

// Time vs threads
function refreshTimeVsThreads(){
    var infos = timeVsThreadsInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyTimeVsThreads");
        return;
    }
    if(isGraph($("#flotTimesVsThreads"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesTimeVsThreads");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotTimesVsThreads", "#overviewTimesVsThreads");
        $('#footerTimeVsThreads .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var bytesThroughputOverTimeInfos = {
        data : {"result": {"minY": 6087.3, "minX": 1.77030048E12, "maxY": 28653.266666666666, "series": [{"data": [[1.7703006E12, 14139.266666666666], [1.77030048E12, 15189.4], [1.77030054E12, 28653.266666666666]], "isOverall": false, "label": "Bytes received per second", "isController": false}, {"data": [[1.7703006E12, 6087.3], [1.77030048E12, 6538.333333333333], [1.77030054E12, 12335.4]], "isOverall": false, "label": "Bytes sent per second", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.7703006E12, "title": "Bytes Throughput Over Time"}},
        getOptions : function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity) ,
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Bytes / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendBytesThroughputOverTime'
                },
                selection: {
                    mode: "xy"
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s at %x was %y"
                }
            };
        },
        createGraph : function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesBytesThroughputOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotBytesThroughputOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewBytesThroughputOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Bytes throughput Over Time
function refreshBytesThroughputOverTime(fixTimestamps) {
    var infos = bytesThroughputOverTimeInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if(isGraph($("#flotBytesThroughputOverTime"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesBytesThroughputOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotBytesThroughputOverTime", "#overviewBytesThroughputOverTime");
        $('#footerBytesThroughputOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
}

var responseTimesOverTimeInfos = {
        data: {"result": {"minY": 753.1913617276557, "minX": 1.77030048E12, "maxY": 972.90399484536, "series": [{"data": [[1.7703006E12, 972.90399484536], [1.77030048E12, 753.1913617276557], [1.77030054E12, 953.9373608903026]], "isOverall": false, "label": "HTTP Request", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.7703006E12, "title": "Response Time Over Time"}},
        getOptions: function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Average response time in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendResponseTimesOverTime'
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : at %x Average response time was %y ms"
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesResponseTimesOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotResponseTimesOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewResponseTimesOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Response Times Over Time
function refreshResponseTimeOverTime(fixTimestamps) {
    var infos = responseTimesOverTimeInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyResponseTimeOverTime");
        return;
    }
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if(isGraph($("#flotResponseTimesOverTime"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesResponseTimesOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimesOverTime", "#overviewResponseTimesOverTime");
        $('#footerResponseTimesOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var latenciesOverTimeInfos = {
        data: {"result": {"minY": 753.1523695260938, "minX": 1.77030048E12, "maxY": 972.8930412371128, "series": [{"data": [[1.7703006E12, 972.8930412371128], [1.77030048E12, 753.1523695260938], [1.77030054E12, 953.9186009538942]], "isOverall": false, "label": "HTTP Request", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.7703006E12, "title": "Latencies Over Time"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Average response latencies in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendLatenciesOverTime'
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : at %x Average latency was %y ms"
                }
            };
        },
        createGraph: function () {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesLatenciesOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotLatenciesOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewLatenciesOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Latencies Over Time
function refreshLatenciesOverTime(fixTimestamps) {
    var infos = latenciesOverTimeInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyLatenciesOverTime");
        return;
    }
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if(isGraph($("#flotLatenciesOverTime"))) {
        infos.createGraph();
    }else {
        var choiceContainer = $("#choicesLatenciesOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotLatenciesOverTime", "#overviewLatenciesOverTime");
        $('#footerLatenciesOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var connectTimeOverTimeInfos = {
        data: {"result": {"minY": 0.0, "minX": 1.77030048E12, "maxY": 0.05578884223155376, "series": [{"data": [[1.7703006E12, 0.0], [1.77030048E12, 0.05578884223155376], [1.77030054E12, 0.0317965023847378]], "isOverall": false, "label": "HTTP Request", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.7703006E12, "title": "Connect Time Over Time"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getConnectTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Average Connect Time in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendConnectTimeOverTime'
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : at %x Average connect time was %y ms"
                }
            };
        },
        createGraph: function () {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesConnectTimeOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotConnectTimeOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewConnectTimeOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Connect Time Over Time
function refreshConnectTimeOverTime(fixTimestamps) {
    var infos = connectTimeOverTimeInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyConnectTimeOverTime");
        return;
    }
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if(isGraph($("#flotConnectTimeOverTime"))) {
        infos.createGraph();
    }else {
        var choiceContainer = $("#choicesConnectTimeOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotConnectTimeOverTime", "#overviewConnectTimeOverTime");
        $('#footerConnectTimeOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var responseTimePercentilesOverTimeInfos = {
        data: {"result": {"minY": 14.0, "minX": 1.77030048E12, "maxY": 1383.0, "series": [{"data": [[1.7703006E12, 1231.0], [1.77030048E12, 1383.0], [1.77030054E12, 1270.0]], "isOverall": false, "label": "Max", "isController": false}, {"data": [[1.7703006E12, 1101.0], [1.77030048E12, 1071.3], [1.77030054E12, 1088.0]], "isOverall": false, "label": "90th percentile", "isController": false}, {"data": [[1.7703006E12, 1205.0], [1.77030048E12, 1344.4499999999994], [1.77030054E12, 1173.55]], "isOverall": false, "label": "99th percentile", "isController": false}, {"data": [[1.7703006E12, 1134.3], [1.77030048E12, 1117.8999999999999], [1.77030054E12, 1126.6499999999999]], "isOverall": false, "label": "95th percentile", "isController": false}, {"data": [[1.7703006E12, 789.0], [1.77030048E12, 14.0], [1.77030054E12, 779.0]], "isOverall": false, "label": "Min", "isController": false}, {"data": [[1.7703006E12, 969.0], [1.77030048E12, 806.0], [1.77030054E12, 931.0]], "isOverall": false, "label": "Median", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.7703006E12, "title": "Response Time Percentiles Over Time (successful requests only)"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true,
                        fill: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Response Time in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendResponseTimePercentilesOverTime'
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : at %x Response time was %y ms"
                }
            };
        },
        createGraph: function () {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesResponseTimePercentilesOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotResponseTimePercentilesOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewResponseTimePercentilesOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Response Time Percentiles Over Time
function refreshResponseTimePercentilesOverTime(fixTimestamps) {
    var infos = responseTimePercentilesOverTimeInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if(isGraph($("#flotResponseTimePercentilesOverTime"))) {
        infos.createGraph();
    }else {
        var choiceContainer = $("#choicesResponseTimePercentilesOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimePercentilesOverTime", "#overviewResponseTimePercentilesOverTime");
        $('#footerResponseTimePercentilesOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};


var responseTimeVsRequestInfos = {
    data: {"result": {"minY": 36.0, "minX": 11.0, "maxY": 1341.0, "series": [{"data": [[41.0, 1067.0], [40.0, 1327.5], [43.0, 1117.0], [44.0, 1043.5], [45.0, 1038.0], [46.0, 1049.5], [47.0, 1049.5], [49.0, 1041.5], [48.0, 1044.0], [50.0, 982.0], [51.0, 975.0], [53.0, 1046.5], [52.0, 960.5], [54.0, 889.5], [55.0, 903.0], [56.0, 891.0], [57.0, 900.0], [59.0, 867.5], [58.0, 849.0], [61.0, 829.5], [60.0, 841.0], [63.0, 783.5], [62.0, 808.0], [65.0, 341.0], [64.0, 762.0], [67.0, 573.0], [11.0, 844.0], [19.0, 36.0]], "isOverall": false, "label": "Successes", "isController": false}, {"data": [[41.0, 1066.0], [40.0, 1341.0], [43.0, 1122.0], [44.0, 1025.5], [45.0, 1042.0], [46.0, 1054.5], [47.0, 1053.0], [49.0, 1040.0], [48.0, 1050.0], [50.0, 983.0], [51.0, 977.0], [53.0, 1051.0], [52.0, 963.0], [54.0, 892.5], [55.0, 906.0], [56.0, 895.0], [57.0, 903.0], [59.0, 871.0], [58.0, 850.0], [61.0, 833.5], [60.0, 844.0], [63.0, 787.0], [62.0, 809.0], [65.0, 349.0], [64.0, 712.0], [67.0, 575.0], [11.0, 848.0], [19.0, 62.0]], "isOverall": false, "label": "Failures", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 1000, "maxX": 67.0, "title": "Response Time Vs Request"}},
    getOptions: function() {
        return {
            series: {
                lines: {
                    show: false
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                axisLabel: "Global number of requests per second",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Median Response Time in ms",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            legend: {
                noColumns: 2,
                show: true,
                container: '#legendResponseTimeVsRequest'
            },
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s : Median response time at %x req/s was %y ms"
            },
            colors: ["#9ACD32", "#FF6347"]
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesResponseTimeVsRequest"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotResponseTimeVsRequest"), dataset, options);
        // setup overview
        $.plot($("#overviewResponseTimeVsRequest"), dataset, prepareOverviewOptions(options));

    }
};

// Response Time vs Request
function refreshResponseTimeVsRequest() {
    var infos = responseTimeVsRequestInfos;
    prepareSeries(infos.data);
    if (isGraph($("#flotResponseTimeVsRequest"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesResponseTimeVsRequest");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimeVsRequest", "#overviewResponseTimeVsRequest");
        $('#footerResponseRimeVsRequest .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};


var latenciesVsRequestInfos = {
    data: {"result": {"minY": 36.0, "minX": 11.0, "maxY": 1341.0, "series": [{"data": [[41.0, 1067.0], [40.0, 1327.5], [43.0, 1117.0], [44.0, 1043.5], [45.0, 1038.0], [46.0, 1049.5], [47.0, 1049.5], [49.0, 1041.5], [48.0, 1044.0], [50.0, 982.0], [51.0, 975.0], [53.0, 1046.5], [52.0, 960.5], [54.0, 889.5], [55.0, 903.0], [56.0, 891.0], [57.0, 900.0], [59.0, 867.5], [58.0, 849.0], [61.0, 829.5], [60.0, 841.0], [63.0, 783.5], [62.0, 808.0], [65.0, 341.0], [64.0, 762.0], [67.0, 572.5], [11.0, 844.0], [19.0, 36.0]], "isOverall": false, "label": "Successes", "isController": false}, {"data": [[41.0, 1066.0], [40.0, 1341.0], [43.0, 1121.0], [44.0, 1025.5], [45.0, 1042.0], [46.0, 1054.0], [47.0, 1053.0], [49.0, 1040.0], [48.0, 1050.0], [50.0, 983.0], [51.0, 977.0], [53.0, 1051.0], [52.0, 963.0], [54.0, 892.5], [55.0, 906.0], [56.0, 895.0], [57.0, 903.0], [59.0, 871.0], [58.0, 850.0], [61.0, 833.5], [60.0, 844.0], [63.0, 787.0], [62.0, 809.0], [65.0, 349.0], [64.0, 712.0], [67.0, 575.0], [11.0, 848.0], [19.0, 62.0]], "isOverall": false, "label": "Failures", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 1000, "maxX": 67.0, "title": "Latencies Vs Request"}},
    getOptions: function() {
        return{
            series: {
                lines: {
                    show: false
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                axisLabel: "Global number of requests per second",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Median Latency in ms",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            legend: { noColumns: 2,show: true, container: '#legendLatencyVsRequest' },
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s : Median Latency time at %x req/s was %y ms"
            },
            colors: ["#9ACD32", "#FF6347"]
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesLatencyVsRequest"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotLatenciesVsRequest"), dataset, options);
        // setup overview
        $.plot($("#overviewLatenciesVsRequest"), dataset, prepareOverviewOptions(options));
    }
};

// Latencies vs Request
function refreshLatenciesVsRequest() {
        var infos = latenciesVsRequestInfos;
        prepareSeries(infos.data);
        if(isGraph($("#flotLatenciesVsRequest"))){
            infos.createGraph();
        }else{
            var choiceContainer = $("#choicesLatencyVsRequest");
            createLegend(choiceContainer, infos);
            infos.createGraph();
            setGraphZoomable("#flotLatenciesVsRequest", "#overviewLatenciesVsRequest");
            $('#footerLatenciesVsRequest .legendColorBox > div').each(function(i){
                $(this).clone().prependTo(choiceContainer.find("li").eq(i));
            });
        }
};

var hitsPerSecondInfos = {
        data: {"result": {"minY": 25.033333333333335, "minX": 1.77030048E12, "maxY": 52.416666666666664, "series": [{"data": [[1.7703006E12, 25.033333333333335], [1.77030048E12, 28.616666666666667], [1.77030054E12, 52.416666666666664]], "isOverall": false, "label": "hitsPerSecond", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.7703006E12, "title": "Hits Per Second"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of hits / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: "#legendHitsPerSecond"
                },
                selection: {
                    mode : 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s at %x was %y.2 hits/sec"
                }
            };
        },
        createGraph: function createGraph() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesHitsPerSecond"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotHitsPerSecond"), dataset, options);
            // setup overview
            $.plot($("#overviewHitsPerSecond"), dataset, prepareOverviewOptions(options));
        }
};

// Hits per second
function refreshHitsPerSecond(fixTimestamps) {
    var infos = hitsPerSecondInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if (isGraph($("#flotHitsPerSecond"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesHitsPerSecond");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotHitsPerSecond", "#overviewHitsPerSecond");
        $('#footerHitsPerSecond .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
}

var codesPerSecondInfos = {
        data: {"result": {"minY": 8.616666666666667, "minX": 1.77030048E12, "maxY": 34.95, "series": [{"data": [[1.7703006E12, 8.616666666666667], [1.77030048E12, 9.266666666666667], [1.77030054E12, 17.466666666666665]], "isOverall": false, "label": "200", "isController": false}, {"data": [[1.7703006E12, 17.25], [1.77030048E12, 18.516666666666666], [1.77030054E12, 34.95]], "isOverall": false, "label": "401", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.7703006E12, "title": "Codes Per Second"}},
        getOptions: function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of responses / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: "#legendCodesPerSecond"
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "Number of Response Codes %s at %x was %y.2 responses / sec"
                }
            };
        },
    createGraph: function() {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesCodesPerSecond"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotCodesPerSecond"), dataset, options);
        // setup overview
        $.plot($("#overviewCodesPerSecond"), dataset, prepareOverviewOptions(options));
    }
};

// Codes per second
function refreshCodesPerSecond(fixTimestamps) {
    var infos = codesPerSecondInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if(isGraph($("#flotCodesPerSecond"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesCodesPerSecond");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotCodesPerSecond", "#overviewCodesPerSecond");
        $('#footerCodesPerSecond .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var transactionsPerSecondInfos = {
        data: {"result": {"minY": 8.616666666666667, "minX": 1.77030048E12, "maxY": 34.95, "series": [{"data": [[1.7703006E12, 17.25], [1.77030048E12, 18.516666666666666], [1.77030054E12, 34.95]], "isOverall": false, "label": "HTTP Request-failure", "isController": false}, {"data": [[1.7703006E12, 8.616666666666667], [1.77030048E12, 9.266666666666667], [1.77030054E12, 17.466666666666665]], "isOverall": false, "label": "HTTP Request-success", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.7703006E12, "title": "Transactions Per Second"}},
        getOptions: function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of transactions / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: "#legendTransactionsPerSecond"
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s at %x was %y transactions / sec"
                }
            };
        },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesTransactionsPerSecond"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotTransactionsPerSecond"), dataset, options);
        // setup overview
        $.plot($("#overviewTransactionsPerSecond"), dataset, prepareOverviewOptions(options));
    }
};

// Transactions per second
function refreshTransactionsPerSecond(fixTimestamps) {
    var infos = transactionsPerSecondInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyTransactionsPerSecond");
        return;
    }
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if(isGraph($("#flotTransactionsPerSecond"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesTransactionsPerSecond");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotTransactionsPerSecond", "#overviewTransactionsPerSecond");
        $('#footerTransactionsPerSecond .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var totalTPSInfos = {
        data: {"result": {"minY": 8.616666666666667, "minX": 1.77030048E12, "maxY": 34.95, "series": [{"data": [[1.7703006E12, 8.616666666666667], [1.77030048E12, 9.266666666666667], [1.77030054E12, 17.466666666666665]], "isOverall": false, "label": "Transaction-success", "isController": false}, {"data": [[1.7703006E12, 17.25], [1.77030048E12, 18.516666666666666], [1.77030054E12, 34.95]], "isOverall": false, "label": "Transaction-failure", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.7703006E12, "title": "Total Transactions Per Second"}},
        getOptions: function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of transactions / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: "#legendTotalTPS"
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s at %x was %y transactions / sec"
                },
                colors: ["#9ACD32", "#FF6347"]
            };
        },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesTotalTPS"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotTotalTPS"), dataset, options);
        // setup overview
        $.plot($("#overviewTotalTPS"), dataset, prepareOverviewOptions(options));
    }
};

// Total Transactions per second
function refreshTotalTPS(fixTimestamps) {
    var infos = totalTPSInfos;
    // We want to ignore seriesFilter
    prepareSeries(infos.data, false, true);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if(isGraph($("#flotTotalTPS"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesTotalTPS");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotTotalTPS", "#overviewTotalTPS");
        $('#footerTotalTPS .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

// Collapse the graph matching the specified DOM element depending the collapsed
// status
function collapse(elem, collapsed){
    if(collapsed){
        $(elem).parent().find(".fa-chevron-up").removeClass("fa-chevron-up").addClass("fa-chevron-down");
    } else {
        $(elem).parent().find(".fa-chevron-down").removeClass("fa-chevron-down").addClass("fa-chevron-up");
        if (elem.id == "bodyBytesThroughputOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshBytesThroughputOverTime(true);
            }
            document.location.href="#bytesThroughputOverTime";
        } else if (elem.id == "bodyLatenciesOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshLatenciesOverTime(true);
            }
            document.location.href="#latenciesOverTime";
        } else if (elem.id == "bodyCustomGraph") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshCustomGraph(true);
            }
            document.location.href="#responseCustomGraph";
        } else if (elem.id == "bodyConnectTimeOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshConnectTimeOverTime(true);
            }
            document.location.href="#connectTimeOverTime";
        } else if (elem.id == "bodyResponseTimePercentilesOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshResponseTimePercentilesOverTime(true);
            }
            document.location.href="#responseTimePercentilesOverTime";
        } else if (elem.id == "bodyResponseTimeDistribution") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshResponseTimeDistribution();
            }
            document.location.href="#responseTimeDistribution" ;
        } else if (elem.id == "bodySyntheticResponseTimeDistribution") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshSyntheticResponseTimeDistribution();
            }
            document.location.href="#syntheticResponseTimeDistribution" ;
        } else if (elem.id == "bodyActiveThreadsOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshActiveThreadsOverTime(true);
            }
            document.location.href="#activeThreadsOverTime";
        } else if (elem.id == "bodyTimeVsThreads") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshTimeVsThreads();
            }
            document.location.href="#timeVsThreads" ;
        } else if (elem.id == "bodyCodesPerSecond") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshCodesPerSecond(true);
            }
            document.location.href="#codesPerSecond";
        } else if (elem.id == "bodyTransactionsPerSecond") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshTransactionsPerSecond(true);
            }
            document.location.href="#transactionsPerSecond";
        } else if (elem.id == "bodyTotalTPS") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshTotalTPS(true);
            }
            document.location.href="#totalTPS";
        } else if (elem.id == "bodyResponseTimeVsRequest") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshResponseTimeVsRequest();
            }
            document.location.href="#responseTimeVsRequest";
        } else if (elem.id == "bodyLatenciesVsRequest") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshLatenciesVsRequest();
            }
            document.location.href="#latencyVsRequest";
        }
    }
}

/*
 * Activates or deactivates all series of the specified graph (represented by id parameter)
 * depending on checked argument.
 */
function toggleAll(id, checked){
    var placeholder = document.getElementById(id);

    var cases = $(placeholder).find(':checkbox');
    cases.prop('checked', checked);
    $(cases).parent().children().children().toggleClass("legend-disabled", !checked);

    var choiceContainer;
    if ( id == "choicesBytesThroughputOverTime"){
        choiceContainer = $("#choicesBytesThroughputOverTime");
        refreshBytesThroughputOverTime(false);
    } else if(id == "choicesResponseTimesOverTime"){
        choiceContainer = $("#choicesResponseTimesOverTime");
        refreshResponseTimeOverTime(false);
    }else if(id == "choicesResponseCustomGraph"){
        choiceContainer = $("#choicesResponseCustomGraph");
        refreshCustomGraph(false);
    } else if ( id == "choicesLatenciesOverTime"){
        choiceContainer = $("#choicesLatenciesOverTime");
        refreshLatenciesOverTime(false);
    } else if ( id == "choicesConnectTimeOverTime"){
        choiceContainer = $("#choicesConnectTimeOverTime");
        refreshConnectTimeOverTime(false);
    } else if ( id == "choicesResponseTimePercentilesOverTime"){
        choiceContainer = $("#choicesResponseTimePercentilesOverTime");
        refreshResponseTimePercentilesOverTime(false);
    } else if ( id == "choicesResponseTimePercentiles"){
        choiceContainer = $("#choicesResponseTimePercentiles");
        refreshResponseTimePercentiles();
    } else if(id == "choicesActiveThreadsOverTime"){
        choiceContainer = $("#choicesActiveThreadsOverTime");
        refreshActiveThreadsOverTime(false);
    } else if ( id == "choicesTimeVsThreads"){
        choiceContainer = $("#choicesTimeVsThreads");
        refreshTimeVsThreads();
    } else if ( id == "choicesSyntheticResponseTimeDistribution"){
        choiceContainer = $("#choicesSyntheticResponseTimeDistribution");
        refreshSyntheticResponseTimeDistribution();
    } else if ( id == "choicesResponseTimeDistribution"){
        choiceContainer = $("#choicesResponseTimeDistribution");
        refreshResponseTimeDistribution();
    } else if ( id == "choicesHitsPerSecond"){
        choiceContainer = $("#choicesHitsPerSecond");
        refreshHitsPerSecond(false);
    } else if(id == "choicesCodesPerSecond"){
        choiceContainer = $("#choicesCodesPerSecond");
        refreshCodesPerSecond(false);
    } else if ( id == "choicesTransactionsPerSecond"){
        choiceContainer = $("#choicesTransactionsPerSecond");
        refreshTransactionsPerSecond(false);
    } else if ( id == "choicesTotalTPS"){
        choiceContainer = $("#choicesTotalTPS");
        refreshTotalTPS(false);
    } else if ( id == "choicesResponseTimeVsRequest"){
        choiceContainer = $("#choicesResponseTimeVsRequest");
        refreshResponseTimeVsRequest();
    } else if ( id == "choicesLatencyVsRequest"){
        choiceContainer = $("#choicesLatencyVsRequest");
        refreshLatenciesVsRequest();
    }
    var color = checked ? "black" : "#818181";
    if(choiceContainer != null) {
        choiceContainer.find("label").each(function(){
            this.style.color = color;
        });
    }
}

