import http from "@/utils/requests";
 
/**
 * 分页查询
 * @param {*} listMessage 
 * @returns 
 */
export function guideList(listMessage) {
  return http({
    url: "/api/guide/queryByPage",
    method: "post",
    data: listMessage,
  });
}

/**
 * 根据id查询
 * @param {*} id 
 * @returns 
 */
export function guideGet(id) {
  return http({
    url: `/api/guide/${id}`,
    method: "get"
  });
}

/**
 * 根据id删除
 * @param {*} id 
 * @returns 
 */
export function guideDelete(id) {
  return http({
    url: "/api/guide/deleteById",
    method: "post",
    data: id,
  });
}

/**
 * 增加用例
 * @param {*} guide 
 * @returns 
 */
export function guideAdd(guide) {
  return http({
    url: "/api/guide/add",
    method: "post",
    data: guide,
  });
}

/**
 * 修改用例
 * @param {*} guide 
 * @returns 
 */
export function guideUpdate(guide) {
  return http({
    url: "/api/guide/edit",
    method: "post",
    data: guide,
  });
}
