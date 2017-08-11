db.EMP.insert( 
[{   empno: "7369", 
    ename: "Smith",
    job: "Clerk",
    mgr: 7902,
    hiredate: ISODate("2000-12-17"),
    sal: 800, 
    com: null,
    deptno: 20,
    dname: "Research",
    loc: "Dallas"
 },{   empno: "7499", 
    ename: "Allen",
    job: "Salesman",
    mgr: 7698,
    hiredate: ISODate("2001-02-20"),
    sal: 1600, 
    com: 300,
    deptno: 30,
    dname: "Sales",
    loc: "Chicago"
 },
 {   empno: "7521", 
    ename: "Ward",
    job: "Salesman",
    mgr: 7698,
    hiredate: ISODate("2001-02-22"),
    sal: 1250, 
    com: 500,
    deptno: 30,
    dname: "Sales",
    loc: "Chicago"
 },
  {   empno: "7566", 
    ename: "Jones",
    job: "Manager",
    mgr: 7839,
    hiredate: ISODate("2002-03-01"),
    sal: 2975, 
    com: null,
    deptno: 20,
    dname: "Research",
    loc: "Dallas"
 },
  {   empno: "7654", 
    ename: "Martin",
    job: "Salesman",
    mgr: 7698,
    hiredate: ISODate("2001-09-28"),
    sal: 1250, 
    com: 1400,
    deptno: 30,
    dname: "Sales",
    loc: "Chicago"
 },
  {   empno: "7698", 
    ename: "Blake",
    job: "Manager",
    mgr: 7839,
    hiredate: ISODate("2001-05-01"),
    sal: 2850, 
    com: null,
    deptno: 30,
    dname: "Sales",
    loc: "Chicago"
 },
  {   empno: "7782", 
    ename: "Clark",
    job: "Manager",
    mgr: 7839,
    hiredate: ISODate("2001-06-09"),
    sal: 2450, 
    com: null,
    deptno: 10,
    dname: "Accounting",
    loc: "New York"
 },
  {   empno: "7788", 
    ename: "Scott",
    job: "Analyst",
    mgr: 7566,
    hiredate: ISODate("2007-04-19"),
    sal: 3000, 
    com: null,
    deptno: 20,
    dname: "Research",
    loc: "Dallas"
 },
   {   empno: "7839", 
    ename: "King",
    job: "President",
    mgr: null,
    hiredate: ISODate("2001-11-17"),
    sal: 5000, 
    com: null,
    deptno: 10,
    dname: "Accounting",
    loc: "New York"
 },
   {   empno: "7844", 
    ename: "Turner",
    job: "Salesman",
    mgr: 7698,
    hiredate: ISODate("2001-09-08"),
    sal: 1500, 
    com: 0,
    deptno: 30,
    dname: "Sales",
    loc: "Chicago"
 },
   {   empno: "7876", 
    ename: "Adams",
    job: "Clerk",
    mgr: 7788,
    hiredate: ISODate("2007-05-23"),
    sal: 1100, 
    com: null,
    deptno: 20,
    dname: "Research",
    loc: "Dallas"
 },
    {   empno: "7900", 
    ename: "James",
    job: "Clerk",
    mgr: 7698,
    hiredate: ISODate("2001-12-03"),
    sal: 950, 
    com: null,
    deptno: 30,
    dname: "Sales",
    loc: "Chicago"
 },
    {   empno: "7902", 
    ename: "Ford",
    job: "Analyst",
    mgr: 7566,
    hiredate: ISODate("2001-12-03"),
    sal: 3000, 
    com: null,
    deptno: 20,
    dname: "Research",
    loc: "Dallas"
 },
    {   empno: "7934", 
    ename: "Miller",
    job: "Clerk",
    mgr: 7782,
    hiredate: ISODate("2002-01-23"),
    sal: 1300, 
    com: null,
    deptno: 10,
    dname: "Accounting",
    loc: "New York"
 }
 ]
 )
 db.EMP.find()db.EMP.find({    "deptno":{ "$gt":20}},{    "deptno":1,    "ename":1    });db.EMP.find({    "$where": "this.com > (0.6*this.sal)"},{    "deptno":1,    "ename":1    });	db.EMP.find({    "$where": "this.com > (0.5*this.sal)"},{    "deptno":1,    "ename":1    });
 db.EMP.find({     "deptno": 20,    "sal": {            "$gt": 2000            }},{    "job":1,    "dname":1,    "sal":1    });	db.EMP.find({     "deptno": 30,    "sal": {            "$gte": 1500            }},{    "job":1,    "dname":1,    "sal":1    });		db.EMP.find({    "$or":[         { "job" : "Manager"},        {"job" : "President"}    ]},{    "ename":1,    "job":1,    "sal":1    });	db.EMP.find({    "deptno" : {"$ne" : 10}},{    });	db.EMP.find({    "deptno" : 10,        "$or":[         { "job" : "Manager"},        {"job" : "President"}    ]},{    });	db.EMP.find({    "$or":    [   {"job" : "Manager"},        {"$and":[                     { "job" : "Clerk"},                    {"deptno" : 20}                ]}     ]},{    });		db.EMP.find({    "$or":    [    {"$and":[                     { "job" : "Manager"},                    {"deptno" : 10}                ]},        {"$and":[                     { "job" : "Clerk"},                    {"deptno" : 20}                ]}     ]},{    });					db.EMP.find({"$and":[           {"sal":{"$gte" : 2000}},    {       "$and":[{                  "job":                             {"$ne": "Manager"}                            },                                        {"job":                             {"$ne": "Clerk"}                              }                                                                  ]                       }]},{});db.EMP.find({"sal":{"$gt":1200,"$lt":1400 }},{});db.EMP.find({"job":{ "$in":["Manager","Salesman","Analyst"]}},{});db.EMP.find({"com":null},{});db.EMP.find({"com":0},{});db.EMP.find({"com":{"$ne": null    }},{"job":1});db.EMP.find({         "$or":[    {"com":{"$ne": null }},{"com":{"$lt": 100 }}]},{});db.EMP.find({         "ename": { $regex: /^M/ }},{});db.EMP.find({         "ename": /^M/},{});db.EMP.find({         "ename": /.*m$/},{});
  db.EMP.find({         "ename": /.*m.*$/},{});db.EMP.find({         "ename": /^[a-zA-Z]{4}n$/},{});db.EMP.find({         "ename": /^[a-zA-Z]{3}r/},{});db.EMP.find().sort( { ename: 1 } )db.EMP.find({},{ "ename":1 }).sort( { hiredate: -1 } )db.EMP.find({},{ "ename":1,"job":1,"sal":1 }).sort( { hiredate: -1 },{sal:1} )db.EMP.find({},{ "ename":1,"job":1,"sal":1 }).sort( { job: 1 },{sal:-1} )db.EMP.find({},{ "ename":1,"job":1,"sal":1 }).sort( { job: -1 },{sal:-1} )db.EMP.aggregate([    // Project your altered document form with a *new* field for "month"    {"$project": {        "ename": 1,        "month": { "$month": "$hiredate" },          "year" : { "$year" : "$hiredate" }    }},    // Sort by your month value    {"$sort": { "month": 1 }},    // ( if you need to )    {"$project": {        "ename": 1,        "month": 1,        "year" : 1    }},])db.EMP.aggregate([    // Project your altered document form with a *new* field for "month"    {"$project": {        "ename": 1,        "month": { "$month": "$hiredate" },          "year" : { "$year" : "$hiredate" }    }},    // Sort by your month value    {   "$sort": {  "month": 1 ,"year": 1  }        },    // ( if you need to )    {"$project": {        "ename": 1,        "month": 1,        "year" : 1    }},])db.EMP.aggregate([    // Project your altered document form with a *new* field for "month"    {"$match": {        "com" : null         }},    // ( if you need to )    {"$project": {        "ename": 1,        "total" : { $add: [ "$sal", 250 ] }    }},])db.EMP.aggregate([    // Project your altered document form with a *new* field for "month"    {"$match": {        "sal" : {$gte : 2000}         }},    // ( if you need to )    {"$project": {        "ename": 1,        "sal" : 1    }},])db.EMP.aggregate([    // Project your altered document form with a *new* field for "month"    {"$project": {        "ename": 1,        "month": { "$month": "$hiredate" },      }},     {"$match": {        "month" : 2         }},    // ( if you need to )    ])db.EMP.aggregate([	//hire on last date    // Project your altered document form with a *new* field for "month"    {"$project": {        "ename": 1,        "months": { "$month": "$hiredate" },           "days": { "$dayOfMonth": "$hiredate" },    }},     {"$match": {            $or :[ {   $and:[{"months" : {$in:[1,3,5,7,8,10,12]} },                            {"days" : 31} ]},                                                        { $and:[{"months" : {$in:[4,6,9,11]} },                            {"days" : 30} ] },                { $and:[{"months" : {$in:[2]} },                            {"days" : 28} ] }                ]         }},         {"$project": {        "ename": 1    }}])db.EMP.aggregate([    // Emp 12 year old    {"$project": {        "ename": 1,         "hireyear" :{ "$year" : "$hiredate"},        "curdate" : new Date()     }},    {"$project": {        "hireyear" : 1,        "ename" : 1,          "curyear" : {"$year" : "$curdate" },          }},    {"$project": {        "ename" : 1,        "hireyear" : 1,        "curyear" : 1,        "yeardif" : { "$subtract":["$curyear" ,"$hireyear" ]} ,     }}   ,    {"$match" : {        "yeardif" : { $gte : 12}        }},              {"$project": {           "ename" : 1,            "yeardif" : 1                }}   ])db.EMP.aggregate([	//Job manager and hireyear 2007    // Project your altered document form with a *new* field for "month"    {"$project": {        "ename": 1,        "job" : 1,        "hireyear": { "$year": "$hiredate" },      }},     {"$match": {             "$and" :[ { "job" : "Manager" } , { "hireyear" : 2007 } ]         }}   ])db.EMP.aggregate([	//Concat    // Project your altered document form with a *new* field for "month"    {"$project": {        "desc": { $concat: [ "$ename", ", ", "$job" ] }     }},])db.EMP.aggregate([	//First letter Capital    // Project your altered document form with a *new* field for "month"    {"$project": {        "desc" : { $concat: [               {$toUpper: {$substrCP: [ "$ename", 0, 1 ]}},                {$toLower: {$substrCP: [ "$ename", 1, { "$strLenCP": "$ename" } ]}}                                   ] }     }},])db.EMP.aggregate([	//Leading A    // Project your altered document form with a *new* field for "month"    {"$match": {        "ename" : {$nin: [/^a/i]}    }},])db.EMP.aggregate([	//Trailing r    // Project your altered document form with a *new* field for "month"    {"$match": {        "ename" : {$nin: [/^.*r$/i]}    }},])db.EMP.aggregate([	//First 3    // Project your altered document form with a *new* field for "month"    {"$project": {        "desc" : {$substrCP: [ "$ename", 0, 3 ]}    }},])db.EMP.aggregate([	//Last 3    // Project your altered document form with a *new* field for "month"    {"$project": {        "ename" : 1,        "tl" : {"$strLenCP" : "$ename"},    }},    {"$project": {        "ename" : 1,         "len" : { $subtract: [ "$tl" , 3 ] },        "tl" : 1           }},    {"$project": {          "three":  {$substrCP: [ "$ename", "$len", { "$strLenCP": "$ename" } ]}    }}])db.EMP.find().forEach(function(doc) { //Replace a with e  doc.ename = doc.ename.replace(/[a.*$]/ig, 'e');   print(doc.ename);});db.EMP.find().forEach(function(doc) {    var str = doc.ename;    var n = str.indexOf("ar");    if( n == -1)    {        print(doc.ename, " does not have ar in it")    }    else    {        print(doc.ename, " ar is found at index ", n)        }});db.EMP.find().forEach(function(doc) {//Leading A    var str = doc.ename;    if( str[0] == 'A')    {        var res = str.split("A");        print(res[1]);    }    else    {        print(str);        }});db.EMP.find().forEach(function(doc) { //trailing R    var str = doc.ename;    var len = str.length;    if( str[len-1] == 'r')    {      var res = str.split(/r$/i)        print(res[0]);    }    else    {        print(str);        }});db.EMP.find().forEach(function(doc) {    var salround = doc.sal;    salround = Math.round(salround/1000)*1000;;    print(doc.ename+"'s", " rounded of salary is ",salround);});db.EMP.find().forEach(function(doc) {        var salround = doc.sal/30;    print("Daily is ",salround);});db.EMP.find().forEach(function(doc) {  var bonus = doc.sal * 0.2;       if( (doc.sal * 0.2) > 500)    {        print( doc.ename+"'s total salary is ",doc.sal,"+ 500 = ", doc.sal+500)        }        else{            print( doc.ename+"'s total salary is ",doc.sal,"+ ",bonus," = ",doc.sal+bonus)            }});db.EMP.find().forEach(function(doc) { //trailing R    var today = new Date();    var diff = parseInt((today - doc.hiredate) / (1000 * 60 * 60 * 24));    print(diff)});db.EMP.find().forEach(function(doc) { //trailing R    var today = new Date();    var diff = parseInt((today - doc.hiredate) / (1000 * 60 * 60 * 24));    var yr = Math.floor(diff/365);    var days_rem= diff %365;    var months = Math.floor(days_rem/30);    days_rem = days_rem%30;    print(yr,"years ",months,"months ", days_rem,"days")});db.EMP.find().forEach(function(doc) {    var wMonths=['January','February','March','April','May','June','July','August','September','October','November','December'];    var xDay = ['First','Second','Third','Fourth','Fifth','Sixth','Seventh','Eighth','Ninth','Tenth','Eleventh','Twelfth','Thirteenth',    'Fourteenth','Fifteenth','Sixteenth','Seventeenth','Eighteenth','Ninteenth','Twentieth','Twenty-first','Twenty-second','Twenty-third',    'Twenty-fourth','Twenty-fifth','Twenty-sixth','Twenty-seventh','Twenty-eigth','Twenty-ninth','Thirtieth','Thirty-first'    ];        print(doc.ename,"joined on ",xDay[doc.hiredate.getDate()], "of ",wMonths[doc.hiredate.getMonth()],"",doc.hiredate.getFullYear());});db.EMP.find().sort( {"sal" : 1}).limit(1)