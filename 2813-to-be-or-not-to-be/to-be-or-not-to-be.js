/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {
    return {
        toBe: function(com){
            const r= val===com;
            if(!r) {
                throw new Error("Not Equal");           }
            return r;
        },
        notToBe: function(com) {
            const r= val!==com;
            if(!r) {
                throw new Error("Equal");
            }
            return r;
        }
    }
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */