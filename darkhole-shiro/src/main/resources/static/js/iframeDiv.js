/**
 * Created by Administrator on 2017/7/4.
 */
    function iframe(element, wrap) {
        $(element).click(function() {
            var $this = $(this);
            var _clickTab = $this.find('a').attr('target');
            wrap.empty()
            wrap.load(_clickTab)
        });
    }