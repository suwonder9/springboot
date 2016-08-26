--
-- Created by IntelliJ IDEA.
-- User: sujinxian
-- Date: 2016/8/19
-- Time: 14:24
-- To change this template use File | Settings | File Templates.
--

local count = redis.call('get', 'product_count')
local a = tonumber(count)
local b = tonumber(ARGV[1])
if a >= b then
    redis.call('set', 'product_count', count-b)
    return 1
end
return 0