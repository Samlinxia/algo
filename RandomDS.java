class RandomDS {
/**
Array + Hash

Hash的key是array里面的值，value是index

getrandom就直接生成index random access array
insert就insert在array最后，同时update hash
delete就先用hash找到对应的index，假设为i。然后swap第i个和array最后一个，然后
删掉array最后一个，同时更新hash
lookup直接hash搞定
*/

}