/**
 * ウインドウが読み込まれたらinitfunctionが呼ばれる
 */
window.addEventListener('load', init);

var canvas;
var ctx;
// Canvasのサイズを定義
const SCREEN_WIDTH = 800;
const SCREEN_HEIGHT = 600;

/**
 * 初期化
 */
function init(){
    // ここに初期化処理を記載
    canvas = document.getElementById('maincanbas');
    ctx = canvas.getContext('2d')
    canvas.width = SCREEN_WIDTH;
    canvas.height = SCREEN_HEIGHT;
    // 毎フレーム更新処理の作成
    requestAnimationFrame(update);
}

function update(){
    requestAnimationFrame(update);
    render();
}

function render(){
    // ここで描画処理する
}