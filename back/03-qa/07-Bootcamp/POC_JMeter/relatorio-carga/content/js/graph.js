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
        data: {"result": {"minY": 4.0, "minX": 0.0, "maxY": 768.0, "series": [{"data": [[0.0, 4.0], [0.1, 10.0], [0.2, 15.0], [0.3, 19.0], [0.4, 21.0], [0.5, 23.0], [0.6, 26.0], [0.7, 29.0], [0.8, 34.0], [0.9, 39.0], [1.0, 42.0], [1.1, 44.0], [1.2, 46.0], [1.3, 48.0], [1.4, 51.0], [1.5, 53.0], [1.6, 55.0], [1.7, 58.0], [1.8, 60.0], [1.9, 62.0], [2.0, 66.0], [2.1, 71.0], [2.2, 73.0], [2.3, 76.0], [2.4, 79.0], [2.5, 82.0], [2.6, 84.0], [2.7, 86.0], [2.8, 88.0], [2.9, 92.0], [3.0, 98.0], [3.1, 103.0], [3.2, 108.0], [3.3, 115.0], [3.4, 127.0], [3.5, 139.0], [3.6, 144.0], [3.7, 147.0], [3.8, 150.0], [3.9, 154.0], [4.0, 158.0], [4.1, 163.0], [4.2, 166.0], [4.3, 169.0], [4.4, 172.0], [4.5, 174.0], [4.6, 176.0], [4.7, 178.0], [4.8, 181.0], [4.9, 185.0], [5.0, 195.0], [5.1, 202.0], [5.2, 210.0], [5.3, 216.0], [5.4, 219.0], [5.5, 221.0], [5.6, 223.0], [5.7, 224.0], [5.8, 226.0], [5.9, 227.0], [6.0, 229.0], [6.1, 230.0], [6.2, 231.0], [6.3, 233.0], [6.4, 234.0], [6.5, 235.0], [6.6, 237.0], [6.7, 239.0], [6.8, 240.0], [6.9, 241.0], [7.0, 242.0], [7.1, 244.0], [7.2, 245.0], [7.3, 245.0], [7.4, 246.0], [7.5, 247.0], [7.6, 247.0], [7.7, 248.0], [7.8, 249.0], [7.9, 250.0], [8.0, 250.0], [8.1, 251.0], [8.2, 252.0], [8.3, 252.0], [8.4, 253.0], [8.5, 253.0], [8.6, 254.0], [8.7, 255.0], [8.8, 255.0], [8.9, 256.0], [9.0, 257.0], [9.1, 257.0], [9.2, 258.0], [9.3, 258.0], [9.4, 259.0], [9.5, 259.0], [9.6, 260.0], [9.7, 260.0], [9.8, 261.0], [9.9, 261.0], [10.0, 261.0], [10.1, 262.0], [10.2, 262.0], [10.3, 262.0], [10.4, 262.0], [10.5, 263.0], [10.6, 263.0], [10.7, 263.0], [10.8, 263.0], [10.9, 264.0], [11.0, 264.0], [11.1, 264.0], [11.2, 265.0], [11.3, 265.0], [11.4, 265.0], [11.5, 265.0], [11.6, 266.0], [11.7, 266.0], [11.8, 266.0], [11.9, 266.0], [12.0, 266.0], [12.1, 267.0], [12.2, 267.0], [12.3, 267.0], [12.4, 267.0], [12.5, 267.0], [12.6, 268.0], [12.7, 268.0], [12.8, 268.0], [12.9, 268.0], [13.0, 268.0], [13.1, 269.0], [13.2, 269.0], [13.3, 269.0], [13.4, 269.0], [13.5, 269.0], [13.6, 269.0], [13.7, 270.0], [13.8, 270.0], [13.9, 270.0], [14.0, 270.0], [14.1, 270.0], [14.2, 270.0], [14.3, 270.0], [14.4, 271.0], [14.5, 271.0], [14.6, 271.0], [14.7, 271.0], [14.8, 271.0], [14.9, 271.0], [15.0, 272.0], [15.1, 272.0], [15.2, 272.0], [15.3, 272.0], [15.4, 272.0], [15.5, 272.0], [15.6, 272.0], [15.7, 272.0], [15.8, 273.0], [15.9, 273.0], [16.0, 273.0], [16.1, 273.0], [16.2, 273.0], [16.3, 273.0], [16.4, 273.0], [16.5, 273.0], [16.6, 274.0], [16.7, 274.0], [16.8, 274.0], [16.9, 274.0], [17.0, 274.0], [17.1, 274.0], [17.2, 274.0], [17.3, 274.0], [17.4, 275.0], [17.5, 275.0], [17.6, 275.0], [17.7, 275.0], [17.8, 275.0], [17.9, 275.0], [18.0, 275.0], [18.1, 275.0], [18.2, 276.0], [18.3, 276.0], [18.4, 276.0], [18.5, 276.0], [18.6, 276.0], [18.7, 276.0], [18.8, 276.0], [18.9, 276.0], [19.0, 276.0], [19.1, 277.0], [19.2, 277.0], [19.3, 277.0], [19.4, 277.0], [19.5, 277.0], [19.6, 277.0], [19.7, 277.0], [19.8, 277.0], [19.9, 277.0], [20.0, 278.0], [20.1, 278.0], [20.2, 278.0], [20.3, 278.0], [20.4, 278.0], [20.5, 278.0], [20.6, 278.0], [20.7, 278.0], [20.8, 278.0], [20.9, 279.0], [21.0, 279.0], [21.1, 279.0], [21.2, 279.0], [21.3, 279.0], [21.4, 279.0], [21.5, 279.0], [21.6, 279.0], [21.7, 279.0], [21.8, 280.0], [21.9, 280.0], [22.0, 280.0], [22.1, 280.0], [22.2, 280.0], [22.3, 280.0], [22.4, 280.0], [22.5, 280.0], [22.6, 280.0], [22.7, 281.0], [22.8, 281.0], [22.9, 281.0], [23.0, 281.0], [23.1, 281.0], [23.2, 281.0], [23.3, 281.0], [23.4, 281.0], [23.5, 282.0], [23.6, 282.0], [23.7, 282.0], [23.8, 282.0], [23.9, 282.0], [24.0, 282.0], [24.1, 282.0], [24.2, 282.0], [24.3, 283.0], [24.4, 283.0], [24.5, 283.0], [24.6, 283.0], [24.7, 283.0], [24.8, 283.0], [24.9, 283.0], [25.0, 283.0], [25.1, 283.0], [25.2, 284.0], [25.3, 284.0], [25.4, 284.0], [25.5, 284.0], [25.6, 284.0], [25.7, 284.0], [25.8, 284.0], [25.9, 284.0], [26.0, 285.0], [26.1, 285.0], [26.2, 285.0], [26.3, 285.0], [26.4, 285.0], [26.5, 285.0], [26.6, 285.0], [26.7, 285.0], [26.8, 286.0], [26.9, 286.0], [27.0, 286.0], [27.1, 286.0], [27.2, 286.0], [27.3, 286.0], [27.4, 286.0], [27.5, 286.0], [27.6, 287.0], [27.7, 287.0], [27.8, 287.0], [27.9, 287.0], [28.0, 287.0], [28.1, 287.0], [28.2, 287.0], [28.3, 288.0], [28.4, 288.0], [28.5, 288.0], [28.6, 288.0], [28.7, 288.0], [28.8, 288.0], [28.9, 288.0], [29.0, 288.0], [29.1, 289.0], [29.2, 289.0], [29.3, 289.0], [29.4, 289.0], [29.5, 289.0], [29.6, 289.0], [29.7, 289.0], [29.8, 289.0], [29.9, 290.0], [30.0, 290.0], [30.1, 290.0], [30.2, 290.0], [30.3, 290.0], [30.4, 290.0], [30.5, 290.0], [30.6, 290.0], [30.7, 291.0], [30.8, 291.0], [30.9, 291.0], [31.0, 291.0], [31.1, 291.0], [31.2, 291.0], [31.3, 291.0], [31.4, 291.0], [31.5, 292.0], [31.6, 292.0], [31.7, 292.0], [31.8, 292.0], [31.9, 292.0], [32.0, 292.0], [32.1, 292.0], [32.2, 292.0], [32.3, 293.0], [32.4, 293.0], [32.5, 293.0], [32.6, 293.0], [32.7, 293.0], [32.8, 293.0], [32.9, 293.0], [33.0, 294.0], [33.1, 294.0], [33.2, 294.0], [33.3, 294.0], [33.4, 294.0], [33.5, 294.0], [33.6, 294.0], [33.7, 294.0], [33.8, 295.0], [33.9, 295.0], [34.0, 295.0], [34.1, 295.0], [34.2, 295.0], [34.3, 295.0], [34.4, 295.0], [34.5, 296.0], [34.6, 296.0], [34.7, 296.0], [34.8, 296.0], [34.9, 296.0], [35.0, 296.0], [35.1, 296.0], [35.2, 297.0], [35.3, 297.0], [35.4, 297.0], [35.5, 297.0], [35.6, 297.0], [35.7, 297.0], [35.8, 297.0], [35.9, 297.0], [36.0, 297.0], [36.1, 298.0], [36.2, 298.0], [36.3, 298.0], [36.4, 298.0], [36.5, 298.0], [36.6, 298.0], [36.7, 298.0], [36.8, 298.0], [36.9, 299.0], [37.0, 299.0], [37.1, 299.0], [37.2, 299.0], [37.3, 299.0], [37.4, 299.0], [37.5, 299.0], [37.6, 300.0], [37.7, 300.0], [37.8, 300.0], [37.9, 300.0], [38.0, 300.0], [38.1, 300.0], [38.2, 300.0], [38.3, 300.0], [38.4, 301.0], [38.5, 301.0], [38.6, 301.0], [38.7, 301.0], [38.8, 301.0], [38.9, 301.0], [39.0, 301.0], [39.1, 301.0], [39.2, 302.0], [39.3, 302.0], [39.4, 302.0], [39.5, 302.0], [39.6, 302.0], [39.7, 302.0], [39.8, 302.0], [39.9, 302.0], [40.0, 303.0], [40.1, 303.0], [40.2, 303.0], [40.3, 303.0], [40.4, 303.0], [40.5, 303.0], [40.6, 303.0], [40.7, 303.0], [40.8, 304.0], [40.9, 304.0], [41.0, 304.0], [41.1, 304.0], [41.2, 304.0], [41.3, 304.0], [41.4, 304.0], [41.5, 304.0], [41.6, 305.0], [41.7, 305.0], [41.8, 305.0], [41.9, 305.0], [42.0, 305.0], [42.1, 305.0], [42.2, 305.0], [42.3, 305.0], [42.4, 306.0], [42.5, 306.0], [42.6, 306.0], [42.7, 306.0], [42.8, 306.0], [42.9, 306.0], [43.0, 306.0], [43.1, 306.0], [43.2, 307.0], [43.3, 307.0], [43.4, 307.0], [43.5, 307.0], [43.6, 307.0], [43.7, 307.0], [43.8, 307.0], [43.9, 307.0], [44.0, 308.0], [44.1, 308.0], [44.2, 308.0], [44.3, 308.0], [44.4, 308.0], [44.5, 308.0], [44.6, 308.0], [44.7, 308.0], [44.8, 309.0], [44.9, 309.0], [45.0, 309.0], [45.1, 309.0], [45.2, 309.0], [45.3, 309.0], [45.4, 309.0], [45.5, 309.0], [45.6, 309.0], [45.7, 310.0], [45.8, 310.0], [45.9, 310.0], [46.0, 310.0], [46.1, 310.0], [46.2, 310.0], [46.3, 310.0], [46.4, 310.0], [46.5, 311.0], [46.6, 311.0], [46.7, 311.0], [46.8, 311.0], [46.9, 311.0], [47.0, 311.0], [47.1, 311.0], [47.2, 311.0], [47.3, 311.0], [47.4, 312.0], [47.5, 312.0], [47.6, 312.0], [47.7, 312.0], [47.8, 312.0], [47.9, 312.0], [48.0, 312.0], [48.1, 313.0], [48.2, 313.0], [48.3, 313.0], [48.4, 313.0], [48.5, 313.0], [48.6, 313.0], [48.7, 313.0], [48.8, 313.0], [48.9, 314.0], [49.0, 314.0], [49.1, 314.0], [49.2, 314.0], [49.3, 314.0], [49.4, 314.0], [49.5, 314.0], [49.6, 314.0], [49.7, 315.0], [49.8, 315.0], [49.9, 315.0], [50.0, 315.0], [50.1, 315.0], [50.2, 315.0], [50.3, 315.0], [50.4, 316.0], [50.5, 316.0], [50.6, 316.0], [50.7, 316.0], [50.8, 316.0], [50.9, 316.0], [51.0, 316.0], [51.1, 316.0], [51.2, 317.0], [51.3, 317.0], [51.4, 317.0], [51.5, 317.0], [51.6, 317.0], [51.7, 317.0], [51.8, 317.0], [51.9, 318.0], [52.0, 318.0], [52.1, 318.0], [52.2, 318.0], [52.3, 318.0], [52.4, 318.0], [52.5, 318.0], [52.6, 319.0], [52.7, 319.0], [52.8, 319.0], [52.9, 319.0], [53.0, 319.0], [53.1, 319.0], [53.2, 319.0], [53.3, 320.0], [53.4, 320.0], [53.5, 320.0], [53.6, 320.0], [53.7, 320.0], [53.8, 320.0], [53.9, 320.0], [54.0, 321.0], [54.1, 321.0], [54.2, 321.0], [54.3, 321.0], [54.4, 321.0], [54.5, 321.0], [54.6, 321.0], [54.7, 322.0], [54.8, 322.0], [54.9, 322.0], [55.0, 322.0], [55.1, 322.0], [55.2, 322.0], [55.3, 322.0], [55.4, 323.0], [55.5, 323.0], [55.6, 323.0], [55.7, 323.0], [55.8, 323.0], [55.9, 323.0], [56.0, 323.0], [56.1, 324.0], [56.2, 324.0], [56.3, 324.0], [56.4, 324.0], [56.5, 324.0], [56.6, 324.0], [56.7, 324.0], [56.8, 325.0], [56.9, 325.0], [57.0, 325.0], [57.1, 325.0], [57.2, 325.0], [57.3, 325.0], [57.4, 326.0], [57.5, 326.0], [57.6, 326.0], [57.7, 326.0], [57.8, 326.0], [57.9, 326.0], [58.0, 326.0], [58.1, 327.0], [58.2, 327.0], [58.3, 327.0], [58.4, 327.0], [58.5, 327.0], [58.6, 327.0], [58.7, 328.0], [58.8, 328.0], [58.9, 328.0], [59.0, 328.0], [59.1, 328.0], [59.2, 328.0], [59.3, 328.0], [59.4, 329.0], [59.5, 329.0], [59.6, 329.0], [59.7, 329.0], [59.8, 329.0], [59.9, 329.0], [60.0, 330.0], [60.1, 330.0], [60.2, 330.0], [60.3, 330.0], [60.4, 330.0], [60.5, 330.0], [60.6, 331.0], [60.7, 331.0], [60.8, 331.0], [60.9, 331.0], [61.0, 331.0], [61.1, 331.0], [61.2, 332.0], [61.3, 332.0], [61.4, 332.0], [61.5, 332.0], [61.6, 332.0], [61.7, 332.0], [61.8, 333.0], [61.9, 333.0], [62.0, 333.0], [62.1, 333.0], [62.2, 333.0], [62.3, 333.0], [62.4, 333.0], [62.5, 334.0], [62.6, 334.0], [62.7, 334.0], [62.8, 334.0], [62.9, 334.0], [63.0, 334.0], [63.1, 335.0], [63.2, 335.0], [63.3, 335.0], [63.4, 335.0], [63.5, 335.0], [63.6, 336.0], [63.7, 336.0], [63.8, 336.0], [63.9, 336.0], [64.0, 336.0], [64.1, 337.0], [64.2, 337.0], [64.3, 337.0], [64.4, 337.0], [64.5, 337.0], [64.6, 337.0], [64.7, 338.0], [64.8, 338.0], [64.9, 338.0], [65.0, 338.0], [65.1, 338.0], [65.2, 339.0], [65.3, 339.0], [65.4, 339.0], [65.5, 339.0], [65.6, 339.0], [65.7, 339.0], [65.8, 340.0], [65.9, 340.0], [66.0, 340.0], [66.1, 340.0], [66.2, 340.0], [66.3, 340.0], [66.4, 341.0], [66.5, 341.0], [66.6, 341.0], [66.7, 341.0], [66.8, 341.0], [66.9, 341.0], [67.0, 342.0], [67.1, 342.0], [67.2, 342.0], [67.3, 342.0], [67.4, 342.0], [67.5, 343.0], [67.6, 343.0], [67.7, 343.0], [67.8, 343.0], [67.9, 343.0], [68.0, 344.0], [68.1, 344.0], [68.2, 344.0], [68.3, 344.0], [68.4, 344.0], [68.5, 345.0], [68.6, 345.0], [68.7, 345.0], [68.8, 345.0], [68.9, 345.0], [69.0, 346.0], [69.1, 346.0], [69.2, 346.0], [69.3, 346.0], [69.4, 347.0], [69.5, 347.0], [69.6, 347.0], [69.7, 347.0], [69.8, 347.0], [69.9, 348.0], [70.0, 348.0], [70.1, 348.0], [70.2, 348.0], [70.3, 348.0], [70.4, 349.0], [70.5, 349.0], [70.6, 349.0], [70.7, 349.0], [70.8, 349.0], [70.9, 350.0], [71.0, 350.0], [71.1, 350.0], [71.2, 350.0], [71.3, 350.0], [71.4, 350.0], [71.5, 351.0], [71.6, 351.0], [71.7, 351.0], [71.8, 351.0], [71.9, 352.0], [72.0, 352.0], [72.1, 352.0], [72.2, 352.0], [72.3, 352.0], [72.4, 352.0], [72.5, 353.0], [72.6, 353.0], [72.7, 353.0], [72.8, 353.0], [72.9, 353.0], [73.0, 354.0], [73.1, 354.0], [73.2, 354.0], [73.3, 354.0], [73.4, 354.0], [73.5, 354.0], [73.6, 355.0], [73.7, 355.0], [73.8, 355.0], [73.9, 355.0], [74.0, 355.0], [74.1, 356.0], [74.2, 356.0], [74.3, 356.0], [74.4, 356.0], [74.5, 356.0], [74.6, 356.0], [74.7, 357.0], [74.8, 357.0], [74.9, 357.0], [75.0, 357.0], [75.1, 357.0], [75.2, 357.0], [75.3, 357.0], [75.4, 358.0], [75.5, 358.0], [75.6, 358.0], [75.7, 358.0], [75.8, 358.0], [75.9, 358.0], [76.0, 359.0], [76.1, 359.0], [76.2, 359.0], [76.3, 359.0], [76.4, 359.0], [76.5, 360.0], [76.6, 360.0], [76.7, 360.0], [76.8, 360.0], [76.9, 360.0], [77.0, 361.0], [77.1, 361.0], [77.2, 361.0], [77.3, 361.0], [77.4, 361.0], [77.5, 361.0], [77.6, 362.0], [77.7, 362.0], [77.8, 362.0], [77.9, 362.0], [78.0, 363.0], [78.1, 363.0], [78.2, 363.0], [78.3, 363.0], [78.4, 363.0], [78.5, 364.0], [78.6, 364.0], [78.7, 364.0], [78.8, 364.0], [78.9, 364.0], [79.0, 365.0], [79.1, 365.0], [79.2, 365.0], [79.3, 365.0], [79.4, 365.0], [79.5, 365.0], [79.6, 366.0], [79.7, 366.0], [79.8, 366.0], [79.9, 366.0], [80.0, 366.0], [80.1, 367.0], [80.2, 367.0], [80.3, 367.0], [80.4, 367.0], [80.5, 368.0], [80.6, 368.0], [80.7, 368.0], [80.8, 368.0], [80.9, 368.0], [81.0, 369.0], [81.1, 369.0], [81.2, 369.0], [81.3, 369.0], [81.4, 369.0], [81.5, 370.0], [81.6, 370.0], [81.7, 370.0], [81.8, 370.0], [81.9, 370.0], [82.0, 371.0], [82.1, 371.0], [82.2, 371.0], [82.3, 371.0], [82.4, 371.0], [82.5, 372.0], [82.6, 372.0], [82.7, 372.0], [82.8, 372.0], [82.9, 372.0], [83.0, 373.0], [83.1, 373.0], [83.2, 373.0], [83.3, 373.0], [83.4, 373.0], [83.5, 374.0], [83.6, 374.0], [83.7, 374.0], [83.8, 374.0], [83.9, 375.0], [84.0, 375.0], [84.1, 375.0], [84.2, 375.0], [84.3, 376.0], [84.4, 376.0], [84.5, 376.0], [84.6, 376.0], [84.7, 377.0], [84.8, 377.0], [84.9, 377.0], [85.0, 377.0], [85.1, 378.0], [85.2, 378.0], [85.3, 378.0], [85.4, 378.0], [85.5, 379.0], [85.6, 379.0], [85.7, 379.0], [85.8, 379.0], [85.9, 379.0], [86.0, 380.0], [86.1, 380.0], [86.2, 380.0], [86.3, 380.0], [86.4, 381.0], [86.5, 381.0], [86.6, 381.0], [86.7, 381.0], [86.8, 382.0], [86.9, 382.0], [87.0, 382.0], [87.1, 382.0], [87.2, 383.0], [87.3, 383.0], [87.4, 383.0], [87.5, 383.0], [87.6, 383.0], [87.7, 384.0], [87.8, 384.0], [87.9, 384.0], [88.0, 384.0], [88.1, 385.0], [88.2, 385.0], [88.3, 385.0], [88.4, 386.0], [88.5, 386.0], [88.6, 386.0], [88.7, 387.0], [88.8, 387.0], [88.9, 387.0], [89.0, 387.0], [89.1, 388.0], [89.2, 388.0], [89.3, 389.0], [89.4, 389.0], [89.5, 389.0], [89.6, 389.0], [89.7, 390.0], [89.8, 390.0], [89.9, 390.0], [90.0, 391.0], [90.1, 391.0], [90.2, 391.0], [90.3, 392.0], [90.4, 392.0], [90.5, 392.0], [90.6, 393.0], [90.7, 393.0], [90.8, 393.0], [90.9, 394.0], [91.0, 394.0], [91.1, 394.0], [91.2, 395.0], [91.3, 395.0], [91.4, 396.0], [91.5, 396.0], [91.6, 396.0], [91.7, 397.0], [91.8, 397.0], [91.9, 397.0], [92.0, 398.0], [92.1, 398.0], [92.2, 399.0], [92.3, 399.0], [92.4, 400.0], [92.5, 400.0], [92.6, 400.0], [92.7, 401.0], [92.8, 401.0], [92.9, 402.0], [93.0, 402.0], [93.1, 402.0], [93.2, 403.0], [93.3, 403.0], [93.4, 404.0], [93.5, 404.0], [93.6, 404.0], [93.7, 405.0], [93.8, 405.0], [93.9, 406.0], [94.0, 406.0], [94.1, 407.0], [94.2, 407.0], [94.3, 408.0], [94.4, 408.0], [94.5, 409.0], [94.6, 410.0], [94.7, 410.0], [94.8, 411.0], [94.9, 412.0], [95.0, 413.0], [95.1, 413.0], [95.2, 414.0], [95.3, 415.0], [95.4, 416.0], [95.5, 417.0], [95.6, 418.0], [95.7, 419.0], [95.8, 420.0], [95.9, 421.0], [96.0, 422.0], [96.1, 424.0], [96.2, 425.0], [96.3, 426.0], [96.4, 427.0], [96.5, 428.0], [96.6, 429.0], [96.7, 431.0], [96.8, 432.0], [96.9, 434.0], [97.0, 435.0], [97.1, 437.0], [97.2, 439.0], [97.3, 441.0], [97.4, 443.0], [97.5, 444.0], [97.6, 446.0], [97.7, 448.0], [97.8, 450.0], [97.9, 452.0], [98.0, 455.0], [98.1, 460.0], [98.2, 463.0], [98.3, 468.0], [98.4, 476.0], [98.5, 486.0], [98.6, 493.0], [98.7, 501.0], [98.8, 508.0], [98.9, 515.0], [99.0, 530.0], [99.1, 549.0], [99.2, 570.0], [99.3, 600.0], [99.4, 636.0], [99.5, 645.0], [99.6, 651.0], [99.7, 667.0], [99.8, 678.0], [99.9, 694.0], [100.0, 768.0]], "isOverall": false, "label": "GET Produtos", "isController": false}], "supportsControllersDiscrimination": true, "maxX": 100.0, "title": "Response Time Percentiles"}},
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
        data: {"result": {"minY": 57.0, "minX": 0.0, "maxY": 39525.0, "series": [{"data": [[0.0, 2190.0], [300.0, 39525.0], [600.0, 449.0], [700.0, 57.0], [100.0, 1453.0], [200.0, 23476.0], [400.0, 4531.0], [500.0, 447.0]], "isOverall": false, "label": "GET Produtos", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 100, "maxX": 700.0, "title": "Response Time Distribution"}},
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
        data: {"result": {"minY": 941.0, "minX": 0.0, "ticks": [[0, "Requests having \nresponse time <= 500ms"], [1, "Requests having \nresponse time > 500ms and <= 1,500ms"], [2, "Requests having \nresponse time > 1,500ms"], [3, "Requests in error"]], "maxY": 71187.0, "series": [{"data": [[0.0, 71187.0]], "color": "#9ACD32", "isOverall": false, "label": "Requests having \nresponse time <= 500ms", "isController": false}, {"data": [[1.0, 941.0]], "color": "yellow", "isOverall": false, "label": "Requests having \nresponse time > 500ms and <= 1,500ms", "isController": false}, {"data": [], "color": "orange", "isOverall": false, "label": "Requests having \nresponse time > 1,500ms", "isController": false}, {"data": [], "color": "#FF6347", "isOverall": false, "label": "Requests in error", "isController": false}], "supportsControllersDiscrimination": false, "maxX": 1.0, "title": "Synthetic Response Times Distribution"}},
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
        data: {"result": {"minY": 26.89571652836955, "minX": 1.77029706E12, "maxY": 80.0, "series": [{"data": [[1.77029718E12, 80.0], [1.7702973E12, 80.0], [1.77029712E12, 77.87072296775045], [1.77029724E12, 80.0], [1.77029706E12, 26.89571652836955], [1.77029736E12, 79.69248803360362]], "isOverall": false, "label": "Carga - Listar Produtos", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.77029736E12, "title": "Active Threads Over Time"}},
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
        data: {"result": {"minY": 13.161764705882355, "minX": 1.0, "maxY": 345.8470588235294, "series": [{"data": [[2.0, 13.161764705882355], [3.0, 18.111111111111114], [4.0, 22.675675675675677], [5.0, 23.92941176470588], [6.0, 25.092783505154635], [7.0, 28.20588235294117], [8.0, 35.25287356321839], [9.0, 49.42253521126761], [10.0, 49.550000000000004], [11.0, 54.445945945945944], [12.0, 45.15315315315315], [13.0, 52.86315789473685], [14.0, 48.63063063063062], [15.0, 59.83870967741937], [16.0, 59.29906542056075], [17.0, 64.36274509803923], [18.0, 72.3571428571429], [19.0, 70.35714285714285], [20.0, 86.55172413793105], [21.0, 96.85057471264368], [22.0, 79.5673076923077], [23.0, 101.33333333333334], [24.0, 87.40186915887851], [25.0, 86.12844036697244], [26.0, 98.80412371134021], [27.0, 114.80851063829785], [28.0, 124.46341463414633], [29.0, 135.09999999999994], [30.0, 165.2784810126582], [31.0, 165.9], [32.0, 153.45454545454555], [33.0, 151.9277108433736], [34.0, 163.00000000000003], [35.0, 216.06666666666666], [36.0, 165.71764705882347], [37.0, 167.07142857142856], [38.0, 171.1190476190476], [39.0, 163.6818181818182], [40.0, 178.74418604651157], [41.0, 189.97435897435898], [42.0, 189.27906976744183], [43.0, 174.07368421052632], [44.0, 177.37777777777774], [45.0, 222.33766233766238], [46.0, 221.23076923076925], [47.0, 228.4805194805195], [48.0, 233.3896103896104], [49.0, 222.29268292682923], [50.0, 227.29629629629633], [51.0, 235.1136363636363], [52.0, 231.873417721519], [53.0, 265.75342465753414], [54.0, 286.4729729729729], [55.0, 249.49999999999994], [56.0, 274.14473684210526], [57.0, 274.113924050633], [58.0, 255.1647058823529], [59.0, 241.41237113402056], [60.0, 216.05882352941174], [61.0, 244.70103092783506], [62.0, 255.63953488372093], [63.0, 267.5454545454546], [64.0, 294.79746835443035], [65.0, 297.0117647058823], [66.0, 341.8939393939395], [67.0, 287.0104166666668], [68.0, 311.6024096385544], [69.0, 272.3434343434343], [70.0, 238.0446428571428], [71.0, 246.56074766355138], [72.0, 254.91588785046744], [73.0, 268.0], [74.0, 308.3673469387756], [75.0, 253.00884955752207], [76.0, 265.5200000000001], [77.0, 320.39534883720927], [78.0, 345.8470588235294], [79.0, 339.44318181818176], [80.0, 331.3225613680238], [1.0, 17.81818181818182]], "isOverall": false, "label": "GET Produtos", "isController": false}, {"data": [[76.25324423247547, 316.3012561002685]], "isOverall": false, "label": "GET Produtos-Aggregated", "isController": false}], "supportsControllersDiscrimination": true, "maxX": 80.0, "title": "Time VS Threads"}},
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
        data : {"result": {"minY": 9289.583333333334, "minX": 1.77029706E12, "maxY": 2305980.6, "series": [{"data": [[1.77029718E12, 2300230.8], [1.7702973E12, 2106913.2], [1.77029712E12, 2211808.2], [1.77029724E12, 2305980.6], [1.77029706E12, 692928.6], [1.77029736E12, 1590829.8]], "isOverall": false, "label": "Bytes received per second", "isController": false}, {"data": [[1.77029718E12, 30837.5], [1.7702973E12, 28245.833333333332], [1.77029712E12, 29652.083333333332], [1.77029724E12, 30914.583333333332], [1.77029706E12, 9289.583333333334], [1.77029736E12, 21327.083333333332]], "isOverall": false, "label": "Bytes sent per second", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.77029736E12, "title": "Bytes Throughput Over Time"}},
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
        data: {"result": {"minY": 118.89661359049106, "minX": 1.77029706E12, "maxY": 353.7973889954274, "series": [{"data": [[1.77029718E12, 324.0268882583433], [1.7702973E12, 353.7973889954274], [1.77029712E12, 327.6718190121531], [1.77029724E12, 323.2829705505779], [1.77029706E12, 118.89661359049106], [1.77029736E12, 315.52573996288004]], "isOverall": false, "label": "GET Produtos", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.77029736E12, "title": "Response Time Over Time"}},
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
        data: {"result": {"minY": 118.81924198250721, "minX": 1.77029706E12, "maxY": 353.73373653931105, "series": [{"data": [[1.77029718E12, 323.96541007971683], [1.7702973E12, 353.73373653931105], [1.77029712E12, 327.60816412562286], [1.77029724E12, 323.2230608531554], [1.77029706E12, 118.81924198250721], [1.77029736E12, 315.4622447982811]], "isOverall": false, "label": "GET Produtos", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.77029736E12, "title": "Latencies Over Time"}},
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
        data: {"result": {"minY": 0.006056461854058829, "minX": 1.77029706E12, "maxY": 0.032294236375869055, "series": [{"data": [[1.77029718E12, 0.012633427915146602], [1.7702973E12, 0.014677681073904722], [1.77029712E12, 0.013349258764842218], [1.77029724E12, 0.012534537367747166], [1.77029706E12, 0.032294236375869055], [1.77029736E12, 0.006056461854058829]], "isOverall": false, "label": "GET Produtos", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.77029736E12, "title": "Connect Time Over Time"}},
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
        data: {"result": {"minY": 4.0, "minX": 1.77029706E12, "maxY": 768.0, "series": [{"data": [[1.77029718E12, 606.0], [1.7702973E12, 729.0], [1.77029712E12, 768.0], [1.77029724E12, 444.0], [1.77029706E12, 278.0], [1.77029736E12, 432.0]], "isOverall": false, "label": "Max", "isController": false}, {"data": [[1.77029718E12, 375.0], [1.7702973E12, 414.0], [1.77029712E12, 420.0], [1.77029724E12, 383.0], [1.77029706E12, 226.0], [1.77029736E12, 367.0]], "isOverall": false, "label": "90th percentile", "isController": false}, {"data": [[1.77029718E12, 437.0], [1.7702973E12, 520.0], [1.77029712E12, 675.0], [1.77029724E12, 419.60000000000036], [1.77029706E12, 267.39999999999964], [1.77029736E12, 406.0]], "isOverall": false, "label": "99th percentile", "isController": false}, {"data": [[1.77029718E12, 390.0], [1.7702973E12, 441.0], [1.77029712E12, 492.0], [1.77029724E12, 396.0], [1.77029706E12, 237.0], [1.77029736E12, 380.0]], "isOverall": false, "label": "95th percentile", "isController": false}, {"data": [[1.77029718E12, 226.0], [1.7702973E12, 248.0], [1.77029712E12, 194.0], [1.77029724E12, 219.0], [1.77029706E12, 4.0], [1.77029736E12, 227.0]], "isOverall": false, "label": "Min", "isController": false}, {"data": [[1.77029718E12, 317.0], [1.7702973E12, 347.0], [1.77029712E12, 303.0], [1.77029724E12, 316.0], [1.77029706E12, 102.0], [1.77029736E12, 306.0]], "isOverall": false, "label": "Median", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.77029736E12, "title": "Response Time Percentiles Over Time (successful requests only)"}},
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
    data: {"result": {"minY": 10.0, "minX": 105.0, "maxY": 629.0, "series": [{"data": [[105.0, 295.0], [122.0, 10.0], [140.0, 627.5], [143.0, 410.0], [144.0, 494.0], [157.0, 629.0], [156.0, 387.0], [162.0, 411.0], [166.0, 418.5], [167.0, 441.0], [164.0, 561.0], [171.0, 448.0], [174.0, 440.0], [191.0, 152.0], [187.0, 384.5], [189.0, 442.0], [185.0, 391.0], [190.0, 413.0], [194.0, 394.0], [198.0, 382.5], [199.0, 400.0], [193.0, 393.0], [195.0, 412.0], [196.0, 401.5], [197.0, 405.0], [202.0, 45.0], [207.0, 375.0], [200.0, 149.0], [204.0, 376.0], [203.0, 392.0], [206.0, 380.0], [205.0, 393.0], [208.0, 241.5], [215.0, 356.0], [209.0, 386.0], [210.0, 376.0], [214.0, 362.0], [211.0, 376.0], [213.0, 382.0], [216.0, 355.0], [219.0, 348.0], [217.0, 337.0], [221.0, 365.0], [222.0, 358.0], [220.0, 364.0], [218.0, 374.5], [223.0, 367.0], [231.0, 346.0], [228.0, 352.0], [224.0, 263.0], [225.0, 348.0], [226.0, 364.0], [227.0, 351.0], [229.0, 343.0], [230.0, 354.0], [238.0, 328.0], [234.0, 336.0], [235.0, 337.0], [237.0, 330.0], [239.0, 271.0], [233.0, 344.0], [236.0, 334.0], [241.0, 317.0], [242.0, 330.5], [243.0, 330.0], [245.0, 318.0], [246.0, 327.0], [240.0, 330.0], [244.0, 325.0], [247.0, 330.0], [254.0, 304.0], [255.0, 181.5], [252.0, 309.0], [251.0, 291.0], [248.0, 322.0], [249.0, 318.0], [250.0, 313.5], [253.0, 312.0], [268.0, 200.0], [267.0, 292.0], [261.0, 284.0], [264.0, 298.0], [258.0, 310.0], [256.0, 314.5], [257.0, 305.0], [262.0, 302.0], [263.0, 299.0], [259.0, 302.0], [260.0, 305.0], [269.0, 285.5], [270.0, 286.0], [271.0, 291.0], [266.0, 289.0], [265.0, 304.0], [275.0, 272.0], [286.0, 274.0], [277.0, 285.0], [282.0, 283.0], [281.0, 281.0], [287.0, 283.0], [274.0, 293.0], [276.0, 289.0], [272.0, 304.0], [279.0, 286.0], [278.0, 287.0], [273.0, 288.0], [283.0, 286.0], [290.0, 277.0], [289.0, 265.0], [301.0, 269.0], [296.0, 271.0], [288.0, 277.0], [297.0, 269.0], [291.0, 281.0], [293.0, 271.0], [292.0, 275.0], [302.0, 263.0], [309.0, 262.0], [315.0, 253.0], [326.0, 245.0]], "isOverall": false, "label": "Successes", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 1000, "maxX": 326.0, "title": "Response Time Vs Request"}},
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
    data: {"result": {"minY": 9.0, "minX": 105.0, "maxY": 629.0, "series": [{"data": [[105.0, 295.0], [122.0, 9.0], [140.0, 627.5], [143.0, 410.0], [144.0, 494.0], [157.0, 629.0], [156.0, 387.0], [162.0, 411.0], [166.0, 418.5], [167.0, 441.0], [164.0, 561.0], [171.0, 448.0], [174.0, 440.0], [191.0, 152.0], [187.0, 384.5], [189.0, 442.0], [185.0, 391.0], [190.0, 412.5], [194.0, 394.0], [198.0, 382.5], [199.0, 399.0], [193.0, 393.0], [195.0, 412.0], [196.0, 401.0], [197.0, 405.0], [202.0, 45.0], [207.0, 375.0], [200.0, 149.0], [204.0, 376.0], [203.0, 392.0], [206.0, 380.0], [205.0, 393.0], [208.0, 241.0], [215.0, 356.0], [209.0, 386.0], [210.0, 376.0], [214.0, 362.0], [211.0, 376.0], [213.0, 382.0], [216.0, 355.0], [219.0, 348.0], [217.0, 337.0], [221.0, 365.0], [222.0, 358.0], [220.0, 364.0], [218.0, 374.5], [223.0, 367.0], [231.0, 346.0], [228.0, 352.0], [224.0, 263.0], [225.0, 348.0], [226.0, 364.0], [227.0, 350.0], [229.0, 343.0], [230.0, 354.0], [238.0, 328.0], [234.0, 336.0], [235.0, 337.0], [237.0, 330.0], [239.0, 271.0], [233.0, 343.0], [236.0, 334.0], [241.0, 317.0], [242.0, 330.0], [243.0, 330.0], [245.0, 318.0], [246.0, 327.0], [240.0, 330.0], [244.0, 325.0], [247.0, 330.0], [254.0, 304.0], [255.0, 181.5], [252.0, 309.0], [251.0, 291.0], [248.0, 322.0], [249.0, 318.0], [250.0, 313.0], [253.0, 312.0], [268.0, 200.0], [267.0, 292.0], [261.0, 284.0], [264.0, 298.0], [258.0, 310.0], [256.0, 314.5], [257.0, 305.0], [262.0, 302.0], [263.0, 299.0], [259.0, 302.0], [260.0, 305.0], [269.0, 285.5], [270.0, 285.5], [271.0, 291.0], [266.0, 288.5], [265.0, 304.0], [275.0, 272.0], [286.0, 274.0], [277.0, 285.0], [282.0, 283.0], [281.0, 281.0], [287.0, 283.0], [274.0, 292.5], [276.0, 289.0], [272.0, 304.0], [279.0, 286.0], [278.0, 287.0], [273.0, 288.0], [283.0, 286.0], [290.0, 277.0], [289.0, 265.0], [301.0, 269.0], [296.0, 271.0], [288.0, 277.0], [297.0, 269.0], [291.0, 280.0], [293.0, 271.0], [292.0, 275.0], [302.0, 263.0], [309.0, 262.0], [315.0, 253.0], [326.0, 245.0]], "isOverall": false, "label": "Successes", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 1000, "maxX": 326.0, "title": "Latencies Vs Request"}},
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
        data: {"result": {"minY": 75.21666666666667, "minX": 1.77029706E12, "maxY": 247.31666666666666, "series": [{"data": [[1.77029718E12, 246.7], [1.7702973E12, 225.96666666666667], [1.77029712E12, 237.65], [1.77029724E12, 247.31666666666666], [1.77029706E12, 75.21666666666667], [1.77029736E12, 169.28333333333333]], "isOverall": false, "label": "hitsPerSecond", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.77029736E12, "title": "Hits Per Second"}},
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
        data: {"result": {"minY": 74.31666666666666, "minX": 1.77029706E12, "maxY": 247.31666666666666, "series": [{"data": [[1.77029718E12, 246.7], [1.7702973E12, 225.96666666666667], [1.77029712E12, 237.21666666666667], [1.77029724E12, 247.31666666666666], [1.77029706E12, 74.31666666666666], [1.77029736E12, 170.61666666666667]], "isOverall": false, "label": "200", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.77029736E12, "title": "Codes Per Second"}},
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
        data: {"result": {"minY": 74.31666666666666, "minX": 1.77029706E12, "maxY": 247.31666666666666, "series": [{"data": [[1.77029718E12, 246.7], [1.7702973E12, 225.96666666666667], [1.77029712E12, 237.21666666666667], [1.77029724E12, 247.31666666666666], [1.77029706E12, 74.31666666666666], [1.77029736E12, 170.61666666666667]], "isOverall": false, "label": "GET Produtos-success", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.77029736E12, "title": "Transactions Per Second"}},
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
        data: {"result": {"minY": 74.31666666666666, "minX": 1.77029706E12, "maxY": 247.31666666666666, "series": [{"data": [[1.77029718E12, 246.7], [1.7702973E12, 225.96666666666667], [1.77029712E12, 237.21666666666667], [1.77029724E12, 247.31666666666666], [1.77029706E12, 74.31666666666666], [1.77029736E12, 170.61666666666667]], "isOverall": false, "label": "Transaction-success", "isController": false}, {"data": [], "isOverall": false, "label": "Transaction-failure", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.77029736E12, "title": "Total Transactions Per Second"}},
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

